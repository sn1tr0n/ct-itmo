module HW5.Pretty
  ( prettyValue
  ) where

import           Prettyprinter
import           Prettyprinter.Render.Terminal (AnsiStyle)

import qualified Data.ByteString               as B
import           Data.Foldable                 (Foldable (toList))
import           Data.Ratio
import           Data.Scientific               (FPFormat (Fixed),
                                                formatScientific,
                                                fromRationalRepetendUnlimited)
import qualified Data.Text                     as T
import           Data.Word                     (Word8)
import           HW5.Base                      (HiAction (..), HiValue (..))
import           Numeric                       (showHex)

prettyValue :: HiValue -> Doc AnsiStyle
prettyValue (HiValueBool bool) = pretty $ if bool then "true" else "false"
prettyValue (HiValueNumber num) = prettyPrintRational num
prettyValue HiValueNull = pretty "null"
prettyValue (HiValueString s) = pretty $ T.concat [T.singleton '"', s, T.singleton '"']
prettyValue (HiValueFunction fun) = pretty . show $ fun
prettyValue (HiValueList l) = encloseSep (pretty "[ ") (pretty " ]") (pretty ", ") (map prettyValue (toList l))
prettyValue (HiValueBytes byteString) = encloseSep (pretty "[# ") (pretty " #]") (pretty " ") (map prettyPrintHex (B.unpack byteString))
prettyValue (HiValueAction (HiActionRead path)) = pretty $ "read(\"" ++ path ++ "\")"
prettyValue (HiValueAction (HiActionWrite path content)) = pretty ("write( \"" ++ path ++ "," ) <+> prettyValue (HiValueBytes content) <+> pretty ")"
prettyValue (HiValueAction (HiActionMkDir path)) = pretty $ "mkdir(\"" ++ path ++ "\")"
prettyValue (HiValueAction (HiActionChDir path)) = pretty $ "cd(\"" ++ path ++ "\")"
prettyValue (HiValueAction HiActionCwd) = pretty "cwd"
prettyValue (HiValueAction HiActionNow) = pretty "now"
prettyValue (HiValueTime time) = pretty $ "parse-time(\"" ++ show time ++ "\")"
prettyValue (HiValueAction (HiActionRand from to)) = pretty $ "rand( " ++ show from ++ ", " ++ show to ++ " )"

prettyPrintHex :: Word8 -> Doc AnsiStyle
prettyPrintHex word = let (q, r) = quotRem word 16 in
  pretty (showHex q "" ++ showHex r "")

prettyPrintRational :: Rational -> Doc AnsiStyle
prettyPrintRational rational = if denominator rational == 1
  then pretty $ numerator rational
  else tryGetFraction rational

  where
    tryGetFraction :: Rational -> Doc AnsiStyle
    tryGetFraction r = let (s, repeatStart) = fromRationalRepetendUnlimited r in
       case repeatStart of
        Nothing    -> pretty $ formatScientific Fixed Nothing s
        Just _ -> let
          den        = denominator r
          (quotient, remainder) = quotRem (numerator r) den
          in
          printFractionWithIntegerPart quotient remainder den

    printFractionWithIntegerPart :: Integer -> Integer -> Integer -> Doc AnsiStyle
    printFractionWithIntegerPart 0 num den = printFraction num den
    printFractionWithIntegerPart integer num den = pretty integer
      <+> pretty (if num < 0 then "-" else"+")
      <+> printFraction (abs num) den

    printFraction :: Integer -> Integer -> Doc AnsiStyle
    printFraction num den = pretty $ show num ++ "/" ++ show den
