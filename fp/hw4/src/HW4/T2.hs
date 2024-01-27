{-# LANGUAGE DerivingStrategies         #-}
{-# LANGUAGE GeneralisedNewtypeDeriving #-}

module HW4.T2
  ( ParseError (..)
  , runP
  , pChar
  , parseError
  , parseExpr
  ) where

import           Control.Applicative
import           Control.Monad
import           Numeric.Natural     (Natural)

import           Data.Char           (isDigit)
import           Data.Foldable       (foldl')
import           Data.Functor        (($>))
import           Data.Maybe          (fromMaybe)
import           HW4.T1              (ExceptState (..))
import           HW4.Types

-- |Type of parsing error (currently only `ErrorAtPos` supported)
newtype ParseError = ErrorAtPos Natural
  deriving Show

-- |Main parser type
newtype Parser a = P (ExceptState ParseError (Natural, String) a)
  deriving newtype (Functor, Applicative, Monad)

-- |Helper constructor-like function for Parser
mkParser :: ((Natural, String) -> Except ParseError (Annotated (Natural, String) a)) -> Parser a
mkParser consumer = P $ ES consumer

-- |Function for evaluating parser on given string
runP :: Parser a -> String -> Except ParseError a
runP (P parser) s = case runES parser (0, s) of
  Success (x :# _) -> Success x
  Error e          -> Error e

-- |Function for creating abstract parser that consumes Char depends on given predicate
parsePredicate :: (Char -> Bool) -> Parser Char
parsePredicate p = mkParser $ \(pos, s) ->
  case s of
    []     -> Error (ErrorAtPos pos)
    (c:cs) -> if p c
      then Success (c :# (pos + 1, cs))
      else Error (ErrorAtPos pos)

-- |Parser that consumes every Char
pChar :: Parser Char
pChar = parsePredicate (const True)

-- |Parser that runs predicate and does not modify the state if test succeeds. Otherwise, error returns as new state.
testPredicate :: (Char -> Bool) -> Parser Char
testPredicate p = mkParser $ \(pos, s) ->
  case s of
    []        -> Error $ ErrorAtPos pos
    str@(c:_) -> if p c
      then Success (c :# (pos, str))
      else Error (ErrorAtPos pos)

-- |Parser that returns error on current position
parseError :: Parser a
parseError = P $ ES $ \(pos, _) -> Error (ErrorAtPos pos)

instance Alternative Parser where
  empty = parseError
  (P left) <|> (P right) = P $ ES $ \s -> case runES left s of
    Success (posOuter :# sOuter) -> Success (posOuter :# sOuter)
    Error _                      -> case runES right s of
      Error e                      -> Error e
      Success (posInner :# sInner) -> Success (posInner :# sInner)

instance MonadPlus Parser

-- |Parser that consumes single digits
parseDigit :: Parser Char
parseDigit = parsePredicate isDigit

-- |Parser that consumes single given Char
parseChar :: Char -> Parser Char
parseChar c = parsePredicate (c==)

-- |Parser that tests if no chars left in given string 
testEof :: Parser Char
testEof = mkParser $ \(pos, s) -> case s of
  []     -> Success ('\0' :# (pos, s))
  _other -> Error (ErrorAtPos pos)

-- |Parser that consumes zero or more whitespace
parseWhitespaces :: Parser [Char]
parseWhitespaces = many $ parseChar ' '

-- |Wrapper for the parser that allows leading and trailing whitespace
parseTrimmed :: Parser a -> Parser a
parseTrimmed parser = parseWhitespaces *> parser <* parseWhitespaces

-- |Tests if given char is not digit
notFloatPredicate :: Char -> Bool
notFloatPredicate = not . isDigit

-- |Tests if given char is not operation
operationPredicate :: Char -> Bool
operationPredicate c = c == '+' || c == '-' || c == '*' || c == '/'

-- |Converts digit to Double
digitFromChar :: Char -> Double
digitFromChar c = fromIntegral $ fromEnum c - fromEnum '0'

-- |Convert String to Double
convertToDouble :: String -> String -> Double
convertToDouble int frac = convertedInt + convertedFrac
  where
    -- |Converted integer part
    convertedInt  = convertStrToDouble int
    -- |Converted fractional part
    convertedFrac = convertStrToDouble frac / (10.0 ^ length frac)

    -- |Converter from String to Double
    convertStrToDouble :: String -> Double
    convertStrToDouble s = foldl' (\acc x -> acc * 10.0 + digitFromChar x) 0.0 s

-- |Parser that consumes number (int or float) and converts it into (Val num)
parseDouble :: Parser Expr
parseDouble = do
  _    <- parseWhitespaces
  int  <- digitsSeq
  frac <- optional $ do
    _ <- parseChar '.'
    digitsSeq
  _    <- testPredicate notFloatPredicate <|> testPredicate operationPredicate <|> testEof

  return $ Val $ convertToDouble int (fromMaybe "" frac)

  where
    -- |Parser that represents not empty sequence of digits
    digitsSeq :: Parser String
    digitsSeq = some parseDigit

-- |Typealias for Op constructor function
type PrimBiConstr = (Expr -> Expr -> Prim Expr)

-- |Abstract parser generator for operation (for given list of (operation token, operation constructor))
parseOperation :: [(Char, PrimBiConstr)] -> Parser PrimBiConstr
parseOperation = parseTrimmed . foldr appendOperationParser parseError
  where
    -- |Function for adding operation parser to the resulting parsers chain
    appendOperationParser :: (Char, PrimBiConstr) -> Parser PrimBiConstr -> Parser PrimBiConstr
    appendOperationParser (c, constr) p = p <|> parseChar c $> constr

-- |Parser for low order (LO) operations (+, -)
parseLOperation :: Parser PrimBiConstr
parseLOperation = parseOperation [('+', Add), ('-', Sub)]

-- |Parser for high order (HO) operations (*, /)
parseHOperation :: Parser PrimBiConstr
parseHOperation = parseOperation  [('*', Mul), ('/', Div)]

-- |Parser generator that consumes some value into brackets `(` (maybe ` `) `value` (maybe ` `) `)`
exactlyBracketed :: Parser a -> Parser a
exactlyBracketed parser = parseChar '(' *> parseTrimmed parser <* parseChar ')'

-- |Parser generator that tries to put value into brackets, and if fails, tries just parse value
maybeBracketed :: Parser a -> Parser a
maybeBracketed parser = exactlyBracketed parser <|> parser

-- |Parser that parses number (maybe in brackets) Without WhiteSpaces
parseDoubleWWS :: Parser Expr
parseDoubleWWS = maybeBracketed $ parseTrimmed parseDouble

-- |Parser for basic operand of binary operator (`a` in `a op b`)
parseBasicOperand :: Parser Expr
parseBasicOperand = parseTrimmed $ exactlyBracketed parseExpression <|> parseDoubleWWS

-- |Parser for basic left operand of binary operator (`a` in `a op b`) and maybe continuation (`op b`)
parseBasicExpr :: (Expr -> Parser Expr) -> Parser Expr
parseBasicExpr tryContinue = do
  left <- parseBasicOperand
  tryContinue left <|> return left

-- |Parser for basic pair `operation and right operand` (`op b` in `a op b`), and maybe continuation of these pairs (`tryConsume`)
parseBasicPartExpr :: Parser PrimBiConstr
 -> Parser Expr
 -> (Expr -> Parser Expr)
 -> Expr
 -> Parser Expr
parseBasicPartExpr operator operand tryContinue left = do
  op    <- operator
  right <- operand

  let prim = Op $ op left right
  tryContinue prim <|> return prim

-- |Parser for left operand of high order expression (`1` in `1 * 2 / 3`)
parseHOExpr :: Parser Expr
parseHOExpr = parseBasicExpr parsePartHOExpr

-- |Parser for (operator, right) of high order expression (`* 2` in `1 * 2 / 3`) and maybe continuation (`/ 3`) if exists
parsePartHOExpr :: Expr -> Parser Expr
parsePartHOExpr = parseBasicPartExpr parseHOperation hORightOperand parsePartHOExpr
  where
    hORightOperand :: Parser Expr
    hORightOperand = exactlyBracketed parseExpression <|> parseDoubleWWS

-- |Parser for left operand of low order expression (`1` in `1 + 2 - 3`)
parseLOExpr :: Parser Expr
parseLOExpr = parseBasicExpr parsePartLOExpr

-- |Parser for (operator, right) of high order expression (`+ 2` in `1 + 2 - 3`) and maybe continuation (`- 3`) if exists
parsePartLOExpr :: Expr -> Parser Expr
parsePartLOExpr = parseBasicPartExpr parseLOperation lORightOperand parsePartExpression
  where
    lORightOperand :: Parser Expr
    lORightOperand = parseHOExpr <|> exactlyBracketed parseExpression <|> parseDoubleWWS

-- |Parser for a well-formed expression (ex. `1`, `2 + 3`, `4 * (5 - 6)`) with continuation if exists
parseExpression :: Parser Expr
parseExpression = do
  expr <- maybeBracketed expressionParser
  parsePartExpression expr <|> return expr

  where
    expressionParser :: Parser Expr
    expressionParser = parseHOExpr <|> parseLOExpr <|> parseDoubleWWS <|> exactlyBracketed parseExpression

-- |Parser for a continuation of well-formed expression (ex. `+ 1` in `4 * (5 - 6) + 1`)
parsePartExpression :: Expr -> Parser Expr
parsePartExpression left = parsePartHOExpr left <|> parsePartLOExpr left <|> parseDoubleWWS

-- |Main parsing function
-- Checks that whole string was processed during the parsing process
parseExpr :: String -> Except ParseError Expr
parseExpr = runP (parseExpression <* testEof)

