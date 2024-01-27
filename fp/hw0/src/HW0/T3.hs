module HW0.T3
  ( compose
  , contract
  , i
  , k
  , permute
  , s
  ) where

-- | S combinator
s :: (a -> b -> c) -> (a -> b) -> (a -> c)
s f g x = f x (g x)

-- | K combinator
k :: a -> b -> a
k x _ = x

-- | I combinator
i :: a -> a
i = s k k

-- | B combinator
compose :: (b -> c) -> (a -> b) -> (a -> c)
compose = s (k s) k

-- | W combinator
contract :: (a -> a -> b) -> (a -> b)
contract = s s (k (s k k))

-- | C combinator
permute :: (a -> b -> c) -> (b -> a -> c)
permute = s (s (k s) k (s (k s) k) s) (k k)
