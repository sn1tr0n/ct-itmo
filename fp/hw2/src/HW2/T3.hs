module HW2.T3
  ( epart
  , mcat
  ) where

mCatFolder :: Monoid a => Maybe a -> a -> a
mCatFolder Nothing val       = val
mCatFolder (Just left) right = left <> right

mcat :: Monoid a => [Maybe a] -> a
mcat = foldr mCatFolder mempty

unwrapEither :: (Monoid a, Monoid b) => Either a b -> (a, b)
unwrapEither (Left x)  = (x, mempty)
unwrapEither (Right x) = (mempty, x)

epart :: (Monoid a, Monoid b) => [Either a b] -> (a, b)
epart = foldMap unwrapEither
