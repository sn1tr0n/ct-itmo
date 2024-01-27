{-# LANGUAGE DeriveGeneric #-}

module HW5.Base
  ( HiError (..)
  , HiExpr (..)
  , HiFun (..)
  , HiValue (..)
  , ArityHolder(..)
  , HiAction(..)
  , HiMonad(..)
  ) where

import           Codec.Serialise (Serialise)
import           Data.ByteString (ByteString)
import           Data.Sequence   (Seq)
import           Data.Text       (Text)
import           Data.Time       (UTCTime)
import           GHC.Generics    (Generic)

data HiAction =
    HiActionRead  FilePath
  | HiActionWrite FilePath ByteString
  | HiActionMkDir FilePath
  | HiActionChDir FilePath
  | HiActionCwd
  | HiActionNow
  | HiActionRand Int Int

  deriving (Eq, Ord, Show, Generic)


instance Serialise HiAction

class Monad m => HiMonad m where
  runAction :: HiAction -> m HiValue

class ArityHolder a where
  arity :: a -> Int

data HiFun = HiFunDiv
  | HiFunLessThan
  | HiFunGreaterThan
  | HiFunEquals
  | HiFunNotLessThan
  | HiFunNotGreaterThan
  | HiFunNotEquals
  | HiFunPackBytes
  | HiFunUnpackBytes
  | HiFunEncodeUtf8
  | HiFunDecodeUtf8
  | HiFunToUpper
  | HiFunToLower
  | HiFunAdd
  | HiFunSub
  | HiFunMul
  | HiFunNot
  | HiFunAnd
  | HiFunOr
  | HiFunIf
  | HiFunLength
  | HiFunReverse
  | HiFunTrim
  | HiFunList
  | HiFunRange
  | HiFunFold
  | HiFunZip
  | HiFunUnzip
  | HiFunSerialise
  | HiFunDeserialise
  | HiFunRead
  | HiFunWrite
  | HiFunMkDir
  | HiFunChDir
  | HiFunParseTime
  | HiFunRand
  deriving (Eq, Ord, Enum, Generic)

instance Serialise HiFun

instance Show HiFun where
  show HiFunDiv            = "div"
  show HiFunAdd            = "add"
  show HiFunSub            = "sub"
  show HiFunMul            = "mul"
  show HiFunNot            = "not"
  show HiFunAnd            = "and"
  show HiFunOr             = "or"
  show HiFunLessThan       = "less-than"
  show HiFunGreaterThan    = "greater-than"
  show HiFunEquals         = "equals"
  show HiFunNotLessThan    = "not-less-than"
  show HiFunNotGreaterThan = "not-greater-than"
  show HiFunNotEquals      = "not-equals"
  show HiFunIf             = "if"
  show HiFunLength         = "length"
  show HiFunToUpper        = "to-upper"
  show HiFunToLower        = "to-lower"
  show HiFunReverse        = "reverse"
  show HiFunTrim           = "trim"
  show HiFunList           = "list"
  show HiFunRange          = "range"
  show HiFunFold           = "fold"
  show HiFunPackBytes      = "pack-bytes"
  show HiFunUnpackBytes    = "unpack-bytes"
  show HiFunEncodeUtf8     = "encode-utf8"
  show HiFunDecodeUtf8     = "decode-utf8"
  show HiFunZip            = "zip"
  show HiFunUnzip          = "unzip"
  show HiFunSerialise      = "serialise"
  show HiFunDeserialise    = "deserialise"
  show HiFunRead           = "read"
  show HiFunWrite          = "write"
  show HiFunMkDir          = "mkdir"
  show HiFunChDir          = "cd"
  show HiFunParseTime      = "parse-time"
  show HiFunRand           = "rand"

instance ArityHolder HiFun where
  -- infinity
  arity HiFunList           = -1

  -- 1
  arity HiFunNot            = 1
  arity HiFunLength         = 1
  arity HiFunToUpper        = 1
  arity HiFunToLower        = 1
  arity HiFunReverse        = 1
  arity HiFunTrim           = 1
  arity HiFunPackBytes      = 1
  arity HiFunUnpackBytes    = 1
  arity HiFunEncodeUtf8     = 1
  arity HiFunDecodeUtf8     = 1
  arity HiFunZip            = 1
  arity HiFunUnzip          = 1
  arity HiFunSerialise      = 1
  arity HiFunDeserialise    = 1
  arity HiFunRead           = 1
  arity HiFunMkDir          = 1
  arity HiFunChDir          = 1
  arity HiFunParseTime      = 1

  -- 2
  arity HiFunAdd            = 2
  arity HiFunSub            = 2
  arity HiFunMul            = 2
  arity HiFunDiv            = 2
  arity HiFunAnd            = 2
  arity HiFunOr             = 2
  arity HiFunLessThan       = 2
  arity HiFunGreaterThan    = 2
  arity HiFunEquals         = 2
  arity HiFunNotLessThan    = 2
  arity HiFunNotGreaterThan = 2
  arity HiFunNotEquals      = 2
  arity HiFunFold           = 2
  arity HiFunRange          = 2
  arity HiFunWrite          = 2
  arity HiFunRand           = 2

  -- 3
  arity HiFunIf             = 3

data HiValue = HiValueBool Bool
  | HiValueNumber Rational
  | HiValueFunction HiFun
  | HiValueNull
  | HiValueString Text
  | HiValueList (Seq HiValue)
  | HiValueBytes ByteString
  | HiValueAction HiAction
  | HiValueTime UTCTime
  deriving (Eq, Ord, Show, Generic)

instance Serialise HiValue

data HiExpr =
   HiExprValue HiValue
  | HiExprApply HiExpr [HiExpr]
  | HiExprRun HiExpr

  deriving (Eq, Show)

data HiError = HiErrorInvalidArgument
  | HiErrorInvalidFunction
  | HiErrorArityMismatch
  | HiErrorDivideByZero
  deriving (Eq, Show)
