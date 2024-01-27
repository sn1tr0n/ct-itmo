module HW0.T4
  ( fac
  , fib
  , map'
  , repeat'
  ) where

import           Data.Function   (fix)
import           Numeric.Natural (Natural)

-- | Repeat using `fix`
repeat' :: a -> [a]
repeat' x = fix (x:)

-- | Map using `fix`
map' :: (a -> b) -> [a] -> [b]
map' f = fix (\rf l -> case l of
  []      -> []
  (h : t) -> f h : rf t)

-- | Fibonacci number using `fix`
fib :: Natural -> Natural
fib = fix (\rf prev cur c -> case c of
  0 -> prev
  _ -> rf cur (prev + cur) (c - 1)) 0 1

-- | Factorial using `fix`
fac :: Natural -> Natural
fac = fix (\rf n -> case n of
  0 -> 1
  _ -> n * rf (n - 1))
