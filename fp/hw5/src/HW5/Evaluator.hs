{-# LANGUAGE ScopedTypeVariables #-}

module HW5.Evaluator
  ( eval
  ) where

import           Codec.Compression.Zlib
import           Codec.Serialise        (deserialise, serialise)
import           Data.ByteString        (pack, unpack)
import qualified Data.ByteString        as BS
import qualified Data.ByteString.Lazy   as BL
import           Data.Foldable          (Foldable (toList))
import           Data.Maybe             (fromMaybe, isNothing)
import           Data.Ratio             (denominator, numerator)
import qualified Data.Semigroup         as T
import qualified Data.Sequence          as S
import qualified Data.String            as BS
import qualified Data.Text              as T
import           Data.Text.Encoding     (decodeUtf8', encodeUtf8)
import           Data.Time              (addUTCTime, diffUTCTime)
import           Data.Word              (Word8)
import           GHC.Base               (Semigroup (stimes))
import           HW5.Base               (ArityHolder (arity),
                                         HiAction (HiActionChDir, HiActionMkDir, HiActionRand, HiActionRead, HiActionWrite),
                                         HiError (..), HiExpr (..), HiFun (..),
                                         HiMonad (..), HiValue (..))
import           Text.Read              (readMaybe)

-- The line below is commented to prevent build error
-- in project template because of 'redundant constraint' warning.
-- Uncomment this line and use correct function signature
-- while doing the homework.
--
eval :: HiMonad m => HiExpr -> m (Either HiError HiValue)
--eval :: HiExpr -> m (Either HiError HiValue)
eval (HiExprValue (HiValueAction action)) = do
      result <- runAction action
      return $ Right result

eval (HiExprValue v) = return $ Right v

eval (HiExprRun expr) = do
  arg <- eval expr
  case arg of
    Left e      -> return $ Left e
    Right value -> eval (HiExprValue value)

eval (HiExprApply (HiExprValue (HiValueString s)) args) =
  makeSliceSemantics
    s
    (\len from to l -> HiValueString $ T.dropEnd (len - to) (T.drop from l))
    (HiValueString T.empty)
    (\l pos -> HiValueString . T.singleton $ T.index l pos)
    T.length
    args

eval (HiExprApply (HiExprValue (HiValueList list)) args) =
  makeSliceSemantics
    list
    (\_ from to l -> HiValueList $ S.take (to - from) (S.drop from l))
    (HiValueList S.Empty)
    S.index
    S.length
    args

eval (HiExprApply (HiExprValue (HiValueBytes bs)) args) =
  makeSliceSemantics
    bs
    (\_ from to l -> HiValueBytes $ BS.take (to - from) (BS.drop from l))
    (HiValueBytes BS.empty)
    (\l pos -> HiValueNumber $ toRational $ BS.index l pos)
    BS.length
    args

eval (HiExprApply (HiExprValue (HiValueFunction HiFunList)) args) = do
  evaledArgs <- evalArgs args
  case evaledArgs of
    Left e     -> return $ Left e
    Right list -> return $ Right (HiValueList (S.fromList list))

eval (HiExprApply (HiExprValue (HiValueFunction fun)) args) = do
  let funArity = arity fun

  if funArity /= length args
    then return $ Left HiErrorArityMismatch
    else do
      evaledArgs <- evalArgs args

      case evaledArgs of
        Left e -> return $ Left e
        Right values -> case funArity of
          1 -> evalUnary fun values
          2 -> evalBinary fun values
          3 -> evalTernary fun values
          _ -> return $ Left HiErrorInvalidFunction
eval (HiExprApply innerFunc args) = do
  evaledFunc <- eval innerFunc

  case evaledFunc of
    Left e                  -> return $ Left e
    Right (HiValueNumber _) -> return $ Left HiErrorInvalidFunction
    Right (HiValueBool _)   -> return $ Left HiErrorInvalidFunction
    Right HiValueNull       -> return $ Left HiErrorInvalidFunction
    Right func              -> eval (HiExprApply (HiExprValue func) args)

evalArgs :: HiMonad m => [HiExpr] -> m (Either HiError [HiValue])
evalArgs [] = return $ Right []
evalArgs (expr:exprs) = do
  evaled <- eval expr
  case evaled of
    Left e -> return $ Left e
    Right val -> do
      rest <- evalArgs exprs
      case rest of
        Left e     -> return $ Left e
        Right vals -> return $ Right (val : vals)

evalUnary :: HiMonad m => HiFun -> [HiValue] -> m (Either HiError HiValue)
evalUnary HiFunNot [HiValueBool a] = return $ Right . HiValueBool $ not a
evalUnary HiFunLength [HiValueString s] = return $ Right $ HiValueNumber $ toRational $ T.length s
evalUnary HiFunLength [HiValueList list] = return $ Right $ HiValueNumber $ toRational $ S.length list

evalUnary HiFunToUpper [HiValueString s] = return $ Right $HiValueString $ T.toUpper s
evalUnary HiFunToLower [HiValueString s] = return $ Right $HiValueString $ T.toLower s
evalUnary HiFunReverse [HiValueString s] = return $ Right $ HiValueString $ T.reverse s
evalUnary HiFunReverse [HiValueList list] = return $ Right $ HiValueList $ S.reverse list
evalUnary HiFunTrim [HiValueString s] = return $ Right $ HiValueString $ T.strip s
evalUnary HiFunPackBytes [HiValueList list] = return $ do
  let maybeWords = map getWordOrError (toList list)
  if any isNothing maybeWords
    then Left HiErrorInvalidArgument
    else Right $ HiValueBytes $ pack $ map (fromMaybe 0) maybeWords -- refactor
  where
    getWordOrError :: HiValue -> Maybe Word8
    getWordOrError (HiValueNumber num) = fromIntegral <$> getRationalIntegerPart num
    getWordOrError _ = Nothing

evalUnary HiFunUnpackBytes [HiValueBytes byteString] = return $ Right $ HiValueList  $ S.fromList (map (HiValueNumber .toRational) (unpack byteString))
evalUnary HiFunEncodeUtf8 [HiValueString s] = return $ Right $ HiValueBytes (encodeUtf8 s)
evalUnary HiFunDecodeUtf8 [HiValueBytes byteString] = return $ Right $ case decodeUtf8' byteString of
  Left _  -> HiValueNull
  Right s -> HiValueString s
evalUnary HiFunZip [HiValueBytes bs] = return $ Right $ HiValueBytes $ fromLazyToStrict $
 compressWith defaultCompressParams { compressLevel = bestCompression } (BL.fromStrict bs)
evalUnary HiFunUnzip [HiValueBytes bs] = return $ Right $ HiValueBytes $ fromLazyToStrict $
 decompressWith defaultDecompressParams (BL.fromStrict bs)
evalUnary HiFunSerialise [value] = return $ Right $ HiValueBytes $ fromLazyToStrict $ serialise value
evalUnary HiFunDeserialise [HiValueBytes bs] = return $ Right $ deserialise (BL.fromStrict bs)

evalUnary HiFunRead [HiValueString path] = getPathAction HiActionRead path
evalUnary HiFunMkDir [HiValueString path] = getPathAction HiActionMkDir path
evalUnary HiFunChDir [HiValueString path] = getPathAction HiActionChDir path

evalUnary HiFunParseTime [HiValueString time] = return $ Right $ maybe HiValueNull HiValueTime (readMaybe (T.unpack time))

evalUnary _ _                      = return $ Left HiErrorInvalidArgument

getPathAction :: HiMonad m => (String -> HiAction) -> T.Text -> m (Either HiError HiValue)
getPathAction constructor t = return $ Right $ HiValueAction (constructor (T.unpack t))

evalBinary :: HiMonad m => HiFun -> [HiValue] -> m (Either HiError HiValue)
evalBinary HiFunLessThan [a, b]       = wrapBoolOpToHiValue $ a < b
evalBinary HiFunGreaterThan [a, b]    = wrapBoolOpToHiValue $ a > b
evalBinary HiFunEquals [a, b]         = wrapBoolOpToHiValue $ a == b
evalBinary HiFunNotLessThan [a, b]    = wrapBoolOpToHiValue $ not (a < b)
evalBinary HiFunNotGreaterThan [a, b] = wrapBoolOpToHiValue $ not (a > b)
evalBinary HiFunNotEquals [a, b]      = wrapBoolOpToHiValue $ not (a == b)

evalBinary HiFunAnd [HiValueBool a, HiValueBool b] = wrapBoolOpToHiValue $ a && b
evalBinary HiFunOr [HiValueBool a, HiValueBool b]  = wrapBoolOpToHiValue $ a || b

evalBinary HiFunAdd [HiValueNumber a, HiValueNumber b]     = return . Right $ HiValueNumber $ a + b
evalBinary HiFunAdd [HiValueString s1, HiValueString s2]   = return . Right $ HiValueString $ T.append s1 s2
evalBinary HiFunAdd [HiValueList list1, HiValueList list2] = return . Right $ HiValueList $ list1 T.<> list2
evalBinary HiFunAdd [HiValueBytes bs1, HiValueBytes bs2]   = return . Right $ HiValueBytes $ BS.append bs1 bs2
evalBinary HiFunAdd [HiValueTime time, HiValueNumber delta]  = getRationalIntegerPartOrError delta (\d -> HiValueTime $ addUTCTime (fromIntegral d) time)

evalBinary HiFunSub [HiValueNumber a, HiValueNumber b] = return . Right $ HiValueNumber $ a - b
evalBinary HiFunSub [HiValueTime a, HiValueTime b] = return . Right $ HiValueNumber $ toRational $ diffUTCTime a b

evalBinary HiFunMul [HiValueNumber a, HiValueNumber b] = return .Right $ HiValueNumber $ a * b
evalBinary HiFunMul [HiValueString s, HiValueNumber r] = getRationalIntegerPartOrError 
  r 
  (\times -> HiValueString $ T.stimes times s)
evalBinary HiFunMul [HiValueList list, HiValueNumber r] = getRationalIntegerPartOrError 
  r
  (\times -> HiValueList $ stimes times list)
evalBinary HiFunMul [HiValueBytes bs, HiValueNumber r] = getRationalIntegerPartOrError 
  r 
  (\times -> HiValueBytes $ stimes times bs)

evalBinary HiFunDiv [HiValueNumber a, HiValueNumber b] = return $ if b == 0
  then Left HiErrorDivideByZero
  else Right $ HiValueNumber $ a / b

evalBinary HiFunDiv [HiValueString s1, HiValueString s2] = return .Right $ HiValueString $ T.concat [s1, T.singleton '/', s2]

evalBinary HiFunFold [HiValueFunction _, HiValueList S.Empty] = return $ Right HiValueNull
evalBinary HiFunFold [HiValueFunction _, HiValueList (value S.:<| S.Empty)] = return $ Right value
evalBinary HiFunFold [f@(HiValueFunction fun), HiValueList (left S.:<| (right S.:<| t))] = do
  folded <- evalBinary fun [left, right]
  case folded of
    Left e    -> return $ Left e
    Right val -> case t of
      S.Empty -> return $ Right val=
      _       -> evalBinary HiFunFold [f, HiValueList (val S.:<| t)]

evalBinary HiFunRange [HiValueNumber from, HiValueNumber to] = return $ Right $ listRange from to
  where
    listRange :: Rational -> Rational -> HiValue
    listRange fromIndex toIndex = HiValueList $ S.fromList $ map HiValueNumber [fromIndex .. toIndex]

evalBinary HiFunWrite [HiValueString path, HiValueString content] = return $ Right $ HiValueAction (HiActionWrite (T.unpack path) (BS.fromString (T.unpack content)))

evalBinary HiFunRand [HiValueNumber from, HiValueNumber to] = return $  do
  let fromParsed = getRationalIntegerPart from
  let toParsed = getRationalIntegerPart to

  if isNothing fromParsed || isNothing toParsed
    then Left HiErrorInvalidArgument
    else Right $ HiValueAction (HiActionRand (fromMaybe 0 fromParsed) (fromMaybe 0 toParsed))

evalBinary _ _ = return $ Left HiErrorInvalidArgument

evalTernary :: Monad m => HiFun -> [HiValue] -> m (Either HiError HiValue)
evalTernary HiFunIf [HiValueBool cond, ifTrue, ifFalse] = return $ Right $
  if cond
    then ifTrue
    else ifFalse
evalTernary _ _ = return $ Left HiErrorInvalidArgument

wrapBoolOpToHiValue :: HiMonad m => Bool -> m (Either HiError HiValue)
wrapBoolOpToHiValue = return . Right . HiValueBool

fromLazyToStrict :: BL.ByteString -> BS.ByteString
fromLazyToStrict = BS.concat . BL.toChunks

getRationalIntegerPart :: Rational -> Maybe Int
getRationalIntegerPart r = if denominator r == 1
  then Just $ fromInteger (numerator r)
  else Nothing

getRationalIntegerPartOrError :: HiMonad m => Rational -> (Int -> HiValue) -> m (Either HiError HiValue)
getRationalIntegerPartOrError r mapper = return $ case getRationalIntegerPart r of
  Nothing  -> Left HiErrorInvalidArgument
  Just int -> Right $ mapper int

makeSliceSemantics :: HiMonad m => funcLike
  -> (Int -> Int -> Int -> funcLike -> HiValue)
  -> HiValue
  -> (funcLike -> Int -> HiValue)
  -> (funcLike -> Int)
  -> [HiExpr] -> m (Either HiError HiValue)
makeSliceSemantics caller subProducer empty singleProducer lenFunc args = do
  let argsLength = length args

  if not (argsLength == 1 || argsLength == 2)
    then return $ Left HiErrorArityMismatch
    else do
      evaledArgs <- evalArgs args

      case evaledArgs of
        Left e -> return $ Left e
        Right evaledArgsList -> case evaledArgsList of
          [HiValueNumber pos] ->
            if pos < 0
            then return $ Right HiValueNull
            else do
              let len = lenFunc caller

              getRationalIntegerPartOrError pos (
                \intPos -> if intPos >= len
                  then HiValueNull
                  else singleProducer caller intPos
                  )
          [from, to] -> do
            let len = lenFunc caller
            let rawFromIndex = elvisOperator from 0
            let rawToIndex = elvisOperator to len

            if isNothing rawFromIndex || isNothing rawToIndex
              then return $ Left HiErrorInvalidArgument
              else do
                let fromIndex = calculateIndex (fromMaybe 0 rawFromIndex) len
                let toIndex = calculateIndex (fromMaybe 0 rawToIndex) len

                return $ Right $ if fromIndex >= toIndex
                  then empty
                  else subProducer len fromIndex toIndex caller

          _ -> return $ Left HiErrorInvalidArgument
  where
    calculateIndex :: Int -> Int -> Int
    calculateIndex raw len = if raw >= 0
      then min raw len
      else max 0 (len + raw)

    elvisOperator :: HiValue -> Int -> Maybe Int -- saying "Hi!" to Kotlin
    elvisOperator HiValueNull def       = Just def
    elvisOperator (HiValueNumber num) _ = getRationalIntegerPart num
    elvisOperator _ _                   = Nothing
