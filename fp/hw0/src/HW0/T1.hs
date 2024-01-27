{-# LANGUAGE TypeOperators #-}

module HW0.T1
  ( type (<->) (Iso)
  , assocEither
  , assocPair
  , distrib
  , flipIso
  , runIso
  ) where

-- | Function isomorphism
data a <-> b = Iso (a -> b) (b -> a)

-- | Distribution for `Either`
distrib :: Either a (b, c) -> (Either a b, Either a c)
distrib (Left a)       = (Left a, Left a)
distrib (Right (b, c)) = (Right b, Right c)

-- | Changing targets for isomorphism
flipIso :: (a <-> b) -> (b <-> a)
flipIso (Iso f g) = Iso g f

-- | Convertion from isomorphism to mapping
runIso :: (a <-> b) -> (a -> b)
runIso (Iso f _) = f

-- | Associativity for pair of isomorphisms
assocPair :: (a, (b, c)) <-> ((a, b), c)
assocPair = Iso leftToRight rightToLeft
  where
    leftToRight :: (a, (b, c)) -> ((a, b), c)
    leftToRight (a, (b, c)) = ((a, b), c)

    rightToLeft :: ((a, b), c) -> (a, (b, c))
    rightToLeft ((a, b), c) = (a, (b, c))

-- | Associativity for `Either` of isomorphisms
assocEither :: Either a (Either b c) <-> Either (Either a b) c
assocEither = Iso leftToRight rightToLeft
  where
    leftToRight :: Either a (Either b c) -> Either (Either a b) c
    leftToRight (Left a)          = Left (Left a)
    leftToRight (Right (Left b))  = Left (Right b)
    leftToRight (Right (Right c)) = Right c

    rightToLeft :: Either (Either a b) c  -> Either a (Either b c)
    rightToLeft (Left (Left a))  = Left a
    rightToLeft (Left (Right b)) = Right (Left b)
    rightToLeft (Right c)        = Right (Right c)

