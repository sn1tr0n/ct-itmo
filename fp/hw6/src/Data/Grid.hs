-- | This module defines 'Grid' datatype.
-- Feel free to define additional helper functions to work
-- with this datatype in this module.
module Data.Grid
  ( Grid (..)
  , left
  , right
  , up
  , down
  , gridWrite
  ) where

import           Control.Comonad (Comonad (..))

import           Data.ListZipper (ListZipper (..), genericMove, listLeft,
                                  listRight, listWrite)

newtype Grid a = Grid { unGrid :: ListZipper (ListZipper a) }

instance Functor Grid where
  fmap f (Grid lz) = Grid ((fmap . fmap) f lz)

instance Comonad Grid where
  extract = gridRead

  duplicate = Grid . fmap horizontal . vertical

-- | Move left in a Grid
left :: Grid a -> Grid a
left (Grid lz) = Grid (fmap listLeft lz)

-- | Move right in a Grid
right :: Grid a -> Grid a
right (Grid lz) = Grid (fmap listRight lz)

-- | Move up in a Grid
up :: Grid a -> Grid a
up (Grid lz) = Grid (listLeft lz)

-- | Move down in a Grid
down :: Grid a -> Grid a
down (Grid lz) = Grid (listRight lz)

gridRead :: Grid a -> a
gridRead (Grid g) = extract $ extract g

-- | Set new value into focused Grid's element
gridWrite :: a -> Grid a -> Grid a
gridWrite x (Grid g) = Grid $ listWrite newLine g
  where
    oldLine = extract g
    newLine = listWrite x oldLine

horizontal  :: Grid a -> ListZipper (Grid a)
horizontal = genericMove left right

vertical :: Grid a -> ListZipper (Grid a)
vertical   = genericMove up down
