{-# LANGUAGE DataKinds            #-}
{-# LANGUAGE TypeFamilies         #-}
{-# LANGUAGE TypeOperators        #-}
{-# LANGUAGE UndecidableInstances #-}

module HW6.T2
  ( TSet

  , Contains
  , Add
  , Delete
  ) where

import           GHC.TypeLits

type TSet = [Symbol]

-- | Type level set's `contains`
type family Contains (name :: Symbol) (set :: TSet) :: Bool where
  Contains _ '[] = 'False
  Contains name (name : _) = 'True
  Contains name (_ : t) = Contains name t

-- | Type level set's `delete`
type family Delete (name :: Symbol) (set :: TSet) :: TSet where
  Delete _ '[] = '[]
  Delete name (name : t) = Delete name t
  Delete name (h : t) = h : Delete name t

-- | Type level set's `add`
type family Add (v :: Symbol) (set :: TSet) :: TSet where
  Add v s = v : Delete v s
