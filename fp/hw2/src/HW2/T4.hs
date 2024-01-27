module HW2.T4
  ( DotString (..)
  , Fun (..)
  , Inclusive (..)
  , ListPlus (..)
  ) where

data ListPlus a = a :+ ListPlus a | Last a
  deriving Show

infixr 5 :+

instance Semigroup (ListPlus a) where
  Last x <> l   = x :+ l
  (h :+ t) <> l = h :+ (t <> l)

data Inclusive a b = This a | That b | Both a b
  deriving Show

-- You may necessary constraints there
instance (Semigroup a, Semigroup b) => Semigroup (Inclusive a b) where
  This i     <>  This j      =  This (i <> j)
  That i     <>  That j      =  That (i <> j)
  Both a1 b1 <>  Both a2 b2  =  Both (a1 <> a2) (b1 <> b2)
  This i     <>  That j      =  Both i j
  That j     <>  This i      =  Both i j
  Both i j   <>  This k      =  Both (i <> k) j
  This k     <>  Both i j    =  Both (k <> i) j
  Both i j   <>  That k      =  Both i (j <> k)
  That k     <>  Both i j    =  Both i (k <> j)

newtype DotString = DS String
  deriving Show

instance Semigroup DotString where
  DS "" <> DS x  = DS x
  DS x  <> DS "" = DS x
  DS a  <> DS b  = DS $ a ++ "." ++ b

instance Monoid DotString where
  mempty = DS ""

newtype Fun a = F (a -> a)

instance Semigroup (Fun a) where
  F f1 <> F f2 = F $ f1 . f2

instance Monoid (Fun a) where
  mempty = F id
