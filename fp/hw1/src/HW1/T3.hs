module HW1.T3
  ( Tree (..)
  , tsize
  , tdepth
  , tmember
  , tinsert
  , tFromList
  ) where

type Meta = (Int, Int)

data Tree a = Leaf | Branch Meta (Tree a) a (Tree a)
  deriving (Show)

tsize :: Tree a -> Int
tsize Leaf                  = 0
tsize (Branch (s, _) _ _ _) = s

mkBranch :: Tree a -> a -> Tree a -> Tree a
mkBranch left mid right = Branch (tsize left + tsize right + 1, max (tdepth left) (tdepth right) + 1) left mid right

tRotateRight :: Tree a -> Tree a
tRotateRight Leaf = Leaf
tRotateRight (Branch _ Leaf mid Leaf) = mkBranch Leaf mid Leaf
tRotateRight (Branch _ Leaf mid right) = mkBranch Leaf mid right
tRotateRight (Branch _ (Branch _ ll lm lr) mid right) = q
    where p = mkBranch lr mid right
          q = mkBranch ll lm p

tRotateLeft :: Tree a -> Tree a
tRotateLeft Leaf = Leaf
tRotateLeft (Branch _ Leaf mid Leaf) = mkBranch Leaf mid Leaf
tRotateLeft (Branch _ left mid Leaf) = mkBranch left mid Leaf
tRotateLeft (Branch _ left mid (Branch _ rl rm rr)) = p
    where q = mkBranch left mid rl
          p = mkBranch q rm rr

tHeightDiff :: Tree a -> Int
tHeightDiff Leaf                    = 0
tHeightDiff (Branch _ left _ right) = tdepth right - tdepth left

tBigRightRotate :: Tree a -> Tree a
tBigRightRotate Leaf = Leaf
tBigRightRotate (Branch _ left mid right) = tRotateLeft $
   mkBranch left mid $
   if tHeightDiff right < 0 then tRotateRight right else right

tBigLeftRotate :: Tree a -> Tree a
tBigLeftRotate Leaf = Leaf
tBigLeftRotate (Branch _ left mid right) = tRotateRight $
  mkBranch (if tHeightDiff left > 0 then tRotateLeft left else left) mid right

tBalance :: Tree a -> Tree a
tBalance Leaf = Leaf
tBalance (Branch _ left mid right) = case tHeightDiff p' of
  2  -> tBigRightRotate p'
  -2 -> tBigLeftRotate p'
  _  -> p'
  where p' = mkBranch left mid right

tdepth :: Tree a -> Int
tdepth Leaf                  = 0
tdepth (Branch (_, h) _ _ _) = h

tmember :: Ord a => a -> Tree a -> Bool
tmember _ Leaf = False
tmember num (Branch _ left mid right)
  | mid == num = True
  | mid <= num = tmember num right
  | otherwise  = tmember num left

tinsert :: Ord a => a -> Tree a -> Tree a
tinsert num Leaf = mkBranch Leaf num Leaf
tinsert num (Branch _ left mid right)
  | mid == num = tBalance $ mkBranch left mid right
  | mid <= num = tBalance $ mkBranch left mid (tinsert num right)
  | otherwise  = tBalance $ mkBranch (tinsert num left) mid right

tFromList :: Ord a => [a] -> Tree a
tFromList list = foldr tinsert Leaf list
