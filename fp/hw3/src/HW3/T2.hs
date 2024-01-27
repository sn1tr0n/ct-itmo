module HW3.T2
  ( distOption
  , wrapOption
  , distPair
  , wrapPair
  , distQuad
  , wrapQuad
  , distAnnotated
  , wrapAnnotated
  , distExcept
  , wrapExcept
  , distPrioritised
  , wrapPrioritised
  , distStream
  , wrapStream
  , distList
  , wrapList
  , distFun
  , wrapFun
  , concatLists
  ) where

import           HW3.T1

distOption :: (Option a, Option b) -> Option (a, b)
distOption (_, None)        = None
distOption (None, _)        = None
distOption (Some x, Some y) = Some (x, y)

wrapOption :: a -> Option a
wrapOption = Some

distPair :: (Pair a, Pair b) -> Pair (a, b)
distPair (P x y, P z k) = P (x, z) (y, k)

wrapPair :: a -> Pair a
wrapPair x = P x x

distQuad :: (Quad a, Quad b) -> Quad (a, b)
distQuad (Q a1 a2 a3 a4, Q b1 b2 b3 b4) = Q (a1, b1) (a2, b2) (a3, b3) (a4, b4)

wrapQuad :: a -> Quad a
wrapQuad x = Q x x x x

distAnnotated :: Semigroup e => (Annotated e a, Annotated e b) -> Annotated e (a, b)
distAnnotated (a1 :# e1, a2 :# e2) = (a1, a2) :# (e1 <> e2)

wrapAnnotated :: Monoid e => a -> Annotated e a
wrapAnnotated x = x :# mempty

distExcept :: (Except e a, Except e b) -> Except e (a, b)
distExcept (Error e, _)           = Error e
distExcept (_, Error e)           = Error e
distExcept (Success x, Success y) = Success (x, y)

wrapExcept :: a -> Except e a
wrapExcept = Success

getPrioritisedArgument :: Prioritised a -> a
getPrioritisedArgument (Low x)    = x
getPrioritisedArgument (Medium x) = x
getPrioritisedArgument (High x)   = x

distPrioritised :: (Prioritised a, Prioritised b) -> Prioritised (a, b)
distPrioritised (High x, y)    = High (x, getPrioritisedArgument y)
distPrioritised (y, High x)    = High (getPrioritisedArgument y, x)
distPrioritised (Medium x, y)  = Medium (x, getPrioritisedArgument y)
distPrioritised (y, Medium x)  = Medium (getPrioritisedArgument y, x)
distPrioritised (Low x, Low y) = Low (x, y)

wrapPrioritised :: a -> Prioritised a
wrapPrioritised = Low

distStream :: (Stream a, Stream b) -> Stream (a, b)
distStream (x :> y, z :> k) = (x, z) :> distStream (y, k)

wrapStream :: a -> Stream a
wrapStream x = x :> wrapStream x

concatLists :: List a -> List a -> List a
concatLists Nil other      = other
concatLists (h :. t) other = h :. concatLists t other

assocElem :: a -> List b -> List (a, b)
assocElem _ Nil      = Nil
assocElem x (h :. t) = (x, h) :. assocElem x t

distList :: (List a, List b) -> List (a, b)
distList (Nil, _)        = Nil
distList (h :. t, other) = concatLists (assocElem h other) remaining
  where remaining = distList (t, other)

wrapList :: a -> List a
wrapList x = x :. Nil

distFun :: (Fun i a, Fun i b) -> Fun i (a, b)
distFun (F func1, F func2) = F (\x -> (func1 x, func2 x))

wrapFun :: a -> Fun i a
wrapFun x = F (\_ -> x)
