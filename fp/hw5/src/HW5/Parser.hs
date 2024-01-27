

module HW5.Parser
  ( parse
  , parseNumber
  ) where

import           Data.Void                       (Void)
import           Text.Megaparsec                 (MonadParsec (notFollowedBy),
                                                  Parsec, between, choice, eof,
                                                  runParser, sepEndBy, skipMany,
                                                  some, try)
import           Text.Megaparsec.Char            (char, hexDigitChar, space1,
                                                  spaceChar, string)
import           Text.Megaparsec.Error           (ParseErrorBundle)

import           Control.Applicative.Combinators (manyTill)
import           Control.Monad.Combinators.Expr  (Operator (..), makeExprParser)
import           Data.ByteString                 (pack)
import           Data.Char                       (toUpper)
import           Data.String                     (IsString (fromString))
import           Data.Word                       (Word8)
import           HW5.Base                        (HiAction (..),
                                                  HiExpr (HiExprApply, HiExprRun, HiExprValue),
                                                  HiFun (..), HiValue (..))
import qualified Text.Megaparsec.Char.Lexer      as L


type Parser = Parsec Void String

parseExprGrammatically :: Parser HiExpr
parseExprGrammatically = makeExprParser (wrappedSc parseExpr) [
  [
    functionApply
  ],
  [
     explicitRun
  ],
  [
    binaryLeft HiFunMul "*",
    binaryLeftWithParser HiFunDiv (try . wrappedSc $ string "/" <* sc <* notFollowedBy (char '='))
    ],
  [
    binaryLeft HiFunAdd "+",
    binaryLeft HiFunSub "-"
    ],
  [
    binaryNon HiFunEquals "==",
    binaryNon HiFunNotEquals "/=",
    binaryNon HiFunNotGreaterThan "<=",
    binaryNon HiFunLessThan "<",
    binaryNon HiFunNotLessThan ">=",
    binaryNon HiFunGreaterThan ">"
    ],

  [
    binaryRight HiFunAnd "&&"
    ],
  [
    binaryRight HiFunOr "||"
    ]
  ]

binaryNon :: HiFun -> String -> Operator Parser HiExpr
binaryNon = binaryOpSimpleString InfixN

binaryLeft :: HiFun -> String -> Operator Parser HiExpr
binaryLeft = binaryOpSimpleString InfixL

binaryLeftWithParser :: HiFun -> Parser String -> Operator Parser HiExpr
binaryLeftWithParser = binaryOp InfixL

binaryRight :: HiFun -> String -> Operator Parser HiExpr
binaryRight = binaryOpSimpleString InfixR

binaryOpSimpleString :: (Parser (HiExpr -> HiExpr -> HiExpr) -> Operator Parser HiExpr)
 -> HiFun -> String -> Operator Parser HiExpr
binaryOpSimpleString constructor fun pattern = binaryOp constructor fun (try $ wrappedSc $ string pattern)

parseSmthInBrackets :: Parser a -> Parser b -> String -> String -> Parser [b] -- maybe replace with sepBy
parseSmthInBrackets sep parser l r = between (wrappedSc $ string l) (wrappedSc $ string r) (parser `sepEndBy` sep)

parseExprInBracketsSepByComma :: String -> String -> Parser [HiExpr]
parseExprInBracketsSepByComma = parseSmthInBrackets (wrappedSc (char ',')) parseExprGrammatically

functionApply :: Operator Parser HiExpr
functionApply = Postfix $ do
  args <- some $ parseExprInBracketsSepByComma "(" ")"
  return $ \expr -> foldl HiExprApply expr args

explicitRun :: Operator Parser HiExpr
explicitRun = Postfix (HiExprRun <$ try (wrappedSc (char '!')))

parseList :: Parser HiExpr
parseList = HiExprApply (HiExprValue (HiValueFunction HiFunList)) <$> parseExprInBracketsSepByComma "[" "]"

binaryOp :: (Parser (HiExpr -> HiExpr -> HiExpr) -> Operator Parser HiExpr)
 -> HiFun -> Parser String -> Operator Parser HiExpr
binaryOp constructor fun parser = constructor $ consumeBinArgs fun <$ parser
  where
    consumeBinArgs :: HiFun -> HiExpr -> HiExpr -> HiExpr
    consumeBinArgs f a b = HiExprApply (HiExprValue $ HiValueFunction f) [a, b]

bracketed :: Parser a -> Parser a
bracketed parser = char '(' *> wrappedSc parser <* char ')'

parseFun :: Parser HiExpr
parseFun = try $ HiExprValue . HiValueFunction <$> choice (map mapFunToParser [ HiFunDiv ..])
  where
    mapFunToParser :: HiFun -> Parser HiFun
    mapFunToParser fun = fun <$ string (show fun)

sc :: Parser ()
sc = skipMany spaceChar

wrappedSc :: Parser a -> Parser a
wrappedSc parser = sc *> parser <* sc

parseExpr :: Parser HiExpr
parseExpr = wrappedSc $ choice [try parseValue, try parseFun, try parseList, try (bracketed parseExprGrammatically)]

--- TODO: toRational ok?
parseNumber :: Parser HiValue
parseNumber = HiValueNumber . toRational <$> L.signed sc L.scientific

parseHexTuple :: Parser Word8
parseHexTuple = try $ do
  first <- hexDigitChar
  second <- hexDigitChar

  return $ fromIntegral (parseHexChar first * 16 + parseHexChar second)

  where
    parseHexChar :: Char -> Int
    parseHexChar c
      | '0' <= c && c <= '9' = fromEnum c - fromEnum '0'
      | otherwise            = fromEnum (toUpper c) - fromEnum 'A' + 10

parseByteString :: Parser HiValue
parseByteString = HiValueBytes . pack <$> parseSmthInBrackets space1 parseHexTuple "[#" "#]"

parseAction :: Parser HiValue
parseAction = HiValueAction <$> choice [
  HiActionCwd <$ wrappedSc (string "cwd"),
  HiActionNow <$ wrappedSc (string "now")
  ]

parseBool :: Parser HiValue
parseBool = HiValueBool <$> choice [
  True <$ string "true",
  False <$ string "false"
  ]

parseNull :: Parser HiValue
parseNull = HiValueNull <$ string "null"

parseString :: Parser HiValue
parseString = HiValueString . fromString <$> try (wrappedSc (char '"' *> manyTill L.charLiteral (char '"')))

parseValue :: Parser HiExpr
parseValue =  HiExprValue <$> choice [try parseNumber, try parseByteString, try parseString, try parseAction, try parseBool, try parseNull]

parse :: String -> Either (ParseErrorBundle String Void) HiExpr
parse = runParser (parseExprGrammatically <* eof) ""
