module HW2.T2
  ( joinWith
  , splitOn
  ) where

import Data.List.NonEmpty (NonEmpty ((:|)), cons, fromList)

empty :: NonEmpty [a]
empty = [] :| []

splitOn :: Eq a => a -> [a] -> NonEmpty [a]
splitOn delim = foldr (folderWithDelim delim) empty

folderWithDelim :: Eq a => a -> a -> NonEmpty [a] -> NonEmpty [a]
folderWithDelim delim c (h :| t)
    | delim == c = [] `cons` (h :| t)
    | otherwise  = (c : h) :| t


joinWith :: a -> NonEmpty [a] -> [a]
joinWith _ (h :| [])    = h
joinWith delim (h :| t) = h ++ [delim] ++ joinWith delim (fromList t)
