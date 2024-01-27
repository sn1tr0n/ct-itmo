module HW3.T3
  ( joinOption
  , joinExcept
  , joinAnnotated
  , joinList
  , joinFun
  ) where

import           HW3.T1
import           HW3.T2 (concatLists)

joinOption :: Option (Option a) -> Option a
joinOption None     = None
joinOption (Some x) = x

joinExcept :: Except e (Except e a) -> Except e a
joinExcept (Error e)   = Error e
joinExcept (Success x) = x

joinAnnotated :: Semigroup e => Annotated e (Annotated e a) -> Annotated e a
joinAnnotated ((ann :# e1) :# e2) = ann :# (e2 <> e1)

joinList :: List (List a) -> List a
joinList Nil      = Nil
joinList (h :. t) = concatLists h $ joinList t

joinFun :: Fun i (Fun i a) -> Fun i a
joinFun (F func) = F (\i -> injectArg (func i) i)
  where
    injectArg :: Fun i a -> i -> a
    injectArg (F f) = f
