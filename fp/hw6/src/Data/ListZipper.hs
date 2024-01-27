-- | This module defines 'ListZipper' datatype.
-- Feel free to define additional helper functions to work
-- with this datatype in this module.
module Data.ListZipper
  ( ListZipper (..),
  listLeft,
  listRight,
  genericMove,
  toList,
  listWrite
  ) where

import           Control.Comonad (Comonad (..))

data ListZipper a = LZ [a] a [a]

instance Functor ListZipper where
  fmap f (LZ l m r) = LZ (map f l) (f m) (map f r)

instance Comonad ListZipper where
  extract (LZ _ a _) = a

  duplicate lz = genericMove listLeft listRight lz

-- | Move left in ListZipper
listLeft :: ListZipper a -> ListZipper a
listLeft (LZ (a:as) x bs) = LZ as a (x:bs)
listLeft _                = error "listLeft"

-- | Move right in ListZipper
listRight :: ListZipper a -> ListZipper a
listRight (LZ as x (b:bs)) = LZ (x:as) b bs
listRight _                = error "listRight"

-- | Set new value to ListZipper's focused element
listWrite :: a -> ListZipper a -> ListZipper a
listWrite x (LZ ls _ rs) = LZ ls x rs

-- | Convert ListZipper to list
--
-- Takes first `n` elements from each side
toList :: Int -> ListZipper a -> [a]
toList n (LZ ls x rs) = reverse (take n ls) ++ [x] ++ take n rs

iterateTail :: (a -> a) -> a -> [a]
iterateTail f = tail . iterate f

-- | Move wrapper for abstract move functions
genericMove :: (z a -> z a)
            -> (z a -> z a)
            -> z a
            -> ListZipper (z a)
genericMove f g e = LZ (iterateTail f e) e (iterateTail g e)
