module HW0.T5
  ( Nat
  , nFromNatural
  , nmult
  , nplus
  , ns
  , nToNum
  , nz
  ) where

import           Numeric.Natural

type Nat a = (a -> a) -> a -> a

-- | Zero
nz :: Nat a
nz _ x = x

-- | One
ns :: Nat a -> Nat a
ns n inc y = inc (n inc y)

-- | Addition
nplus :: Nat a -> Nat a -> Nat a
nplus a b inc y = b inc (a inc y)

-- | Multiplication
nmult :: Nat a -> Nat a -> Nat a
nmult a b inc = a (b inc)

-- | Converting `Natural` to `Nat`
nFromNatural :: Natural -> Nat a
nFromNatural 0 = nz
nFromNatural n = ns (nFromNatural (n - 1))

-- | Converting `Nat` to `Natural`
nToNum :: Num a => Nat a -> a
nToNum n = n (+ 1) 0
