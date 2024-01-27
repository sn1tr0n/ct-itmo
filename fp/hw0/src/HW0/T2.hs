module HW0.T2
  ( Not
  , doubleNeg
  , reduceTripleNeg
  ) where

import           Data.Function ((&))
import           Data.Void     (Void)

type Not a = a -> Void

-- | Performs double negation
doubleNeg :: a -> Not (Not a)
doubleNeg = (&)

-- | Reduces triple negation to single one
reduceTripleNeg :: Not (Not (Not a)) -> Not a
reduceTripleNeg e n = e (doubleNeg n)
