{-# LANGUAGE FlexibleContexts #-}
{-# LANGUAGE TypeFamilies     #-}

module HW6.T1
  ( BucketsArray
  , CHT (..)

  , newCHT
  , getCHT
  , putCHT
  , sizeCHT

  , initCapacity
  , loadFactor
  ) where

import           Control.Concurrent.Classy     (MonadConc (STM, atomically, readTVarConc),
                                                MonadSTM (writeTVar))
import           Control.Concurrent.Classy.STM (TArray, TVar, modifyTVar,
                                                newTVar, readTVar)
import           Control.Monad                 (forM_, when)
import           Data.Array.Base               (MArray (getNumElements))
import           Data.Array.MArray             (MArray (newArray), getElems,
                                                readArray, writeArray)
import           Data.Hashable                 (Hashable (hash))

-- | Initial capacity of CHT
initCapacity :: Int
initCapacity = 16

-- | Load factor of CHT
loadFactor :: Double
loadFactor = 0.75

-- | CHT bucket
type Bucket k v = [(k, v)]
-- | CHT buckets array
type BucketsArray stm k v = TArray stm Int (Bucket k v)

-- | CHT
data CHT stm k v = CHT
  { chtBuckets :: TVar stm (BucketsArray stm k v)
  , chtSize    :: TVar stm Int
  }

-- | Constructs a new Concurrent Hash Table (CHT)
newCHT :: MonadConc m => m (CHT (STM m) k v)
newCHT = atomically $ do
  buckets <- newTVar =<< newArray (0, initCapacity - 1) []
  size <- newTVar 0
  return CHT {
    chtBuckets = buckets,
    chtSize = size
    }

-- | Try to get a value from CHT by key
getCHT
   :: ( MonadConc m
      , Eq k
      , Hashable k
      )
   => k
   -> CHT (STM m) k v
   -> m (Maybe v)
getCHT key cht = atomically $ do
  buckets <- readTVar (chtBuckets cht)
  (bucket, _) <- getBucket key buckets

  return $ lookup key bucket

-- | Gets bucket from buckets array by key
getBucket
  :: ( MArray (TArray stm) (Bucket k v) m
     , Hashable k
     )
  => k
  -> BucketsArray stm k v
  -> m (Bucket k v, Int)
getBucket key buckets = do
  capacity <- getNumElements buckets
  getBucketWithKnownCapacity key buckets capacity

-- | Gets bucket from buckets array by key with known capacity
getBucketWithKnownCapacity
  :: (
     MArray (TArray stm) (Bucket k v) m
     , Hashable k
     )
  => k
  -> BucketsArray stm k v
  -> Int
  -> m (Bucket k v, Int)
getBucketWithKnownCapacity key buckets capacity = do
  let bucketIndex = hash key `mod` capacity
  bucket <- readArray buckets bucketIndex
  return (bucket, bucketIndex)

-- | Puts (key, value) pair in CHT
-- If there is already exists entry with same key, it will be overwritten
putCHT
   :: ( MonadConc m
      , Eq k
      , Hashable k
      )
   => k
   -> v
   -> CHT (STM m) k v
   -> m ()
putCHT key value cht = atomically $ do
  buckets <- readTVar (chtBuckets cht)
  capacity <- getNumElements buckets
  size <- readTVar (chtSize cht)

  (bucket, index) <- getBucketWithKnownCapacity key buckets capacity
  let (updatedBucket, hasBeenRelpaced) = addToBucket bucket
  writeArray buckets index updatedBucket
  modifyTVar (chtSize cht) (+ (if not hasBeenRelpaced then 1 else 0))

  when (fromIntegral size >= fromIntegral capacity * loadFactor) $ resizeCHT capacity buckets

  where
    resizeCHT capacity buckets = do
      let newCapacity = 2 * capacity
      newBuckets <- newArray (0, newCapacity - 1) []
      unwrappedBuckets <- getElems buckets
      forM_ unwrappedBuckets $ \bucket ->
        forM_ bucket (rehashEntry newBuckets newCapacity)
      writeTVar (chtBuckets cht) newBuckets

    rehashEntry newBuckets capacity pair@(k, _) = do
        (newBucket, index) <- getBucketWithKnownCapacity k newBuckets capacity
        writeArray newBuckets index (pair : newBucket)

    addToBucket bucket = case span ((/= key) . fst) bucket of
      (l, [])       -> ((key, value) : l, False)
      (l, _ : rest) -> (rest ++ (key, value) : l, True)

-- | Returns size of CHT
sizeCHT :: MonadConc m => CHT (STM m) k v -> m Int
sizeCHT cht = readTVarConc (chtSize cht)
