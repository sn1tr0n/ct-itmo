module HW1.T2
  ( N (..)
  , nplus
  , nmult
  , nsub
  , nFromNatural
  , nToNum
  , ncmp
  , nEven
  , nOdd
  , ndiv
  , nmod
  ) where

import           Data.Maybe      (fromMaybe)
import           Numeric.Natural

data N = Z | S N

nplus :: N -> N -> N
nplus Z Z           = Z
nplus Z (S n)       = S n
nplus (S n) Z       = S n
nplus (S n1) (S n2) = nplus (S (S n1)) n2

nmult :: N -> N -> N
nmult Z _               = Z
nmult _ Z               = Z
nmult (S Z) (S n)       = S n
nmult (S n) (S Z)       = S n
nmult (S (S n1)) (S n2) = nplus (nmult (S n1) (S n2)) (S n2)


nsub :: N -> N -> Maybe N
nsub Z Z = Just Z
nsub Z _ = Nothing
nsub a Z = Just a
nsub (S a) (S b)
  | ncmp (S a) (S b) == LT = Nothing
  | ncmp (S a) (S b) == EQ = Just Z
  | otherwise              = nsub a b

ncmp :: N -> N -> Ordering
ncmp Z Z           = EQ
ncmp Z _           = LT
ncmp _ Z           = GT
ncmp (S n1) (S n2) = ncmp n1 n2

nFromNatural :: Natural -> N
nFromNatural 0   = Z
nFromNatural num = S (nFromNatural (num - 1))

nToNum :: Num a => N -> a
nToNum Z     = 0
nToNum (S n) = 1 + nToNum n

nEven :: N -> Bool
nEven Z     = True
nEven (S n) = not $ nEven n

nOdd :: N -> Bool
nOdd Z     = False
nOdd (S n) = not $ nOdd n

ndiv :: N -> N -> N
ndiv _ Z = error "Big Ba-Da BOOM!"
ndiv num (S Z) = num
ndiv a b
  | ncmp a b == GT = S (ndiv (fromMaybe (error "halt") (nsub a b) ) b)
  | ncmp a b == EQ = S Z
  | otherwise      = Z

nmod :: N -> N -> N
nmod _ Z = error "Even Bigger Ba-Da BOOM!"
nmod num (S Z) = Z
nmod a b
  | ncmp a b == LT = a
  | ncmp a b == EQ = Z
  | otherwise      = fromMaybe (error "halt") (nsub a (nmult (ndiv a b) b))
