{-# LANGUAGE DataKinds           #-}
{-# LANGUAGE PolyKinds           #-}
{-# LANGUAGE ScopedTypeVariables #-}
{-# LANGUAGE TypeApplications    #-}
{-# OPTIONS_GHC -Wno-unused-top-binds #-}

import           Control.Concurrent.Async  (replicateConcurrently_)
import           Control.Concurrent.Classy (MonadConc (atomically, readTVarConc))
import           Control.Monad             (forM_)
import           Data.Array.Base           (MArray (getNumElements))
import           HW6.T1
import           HW6.T2
import           Test.Hspec                (describe, hspec, it, shouldBe)

data Proxy a = Proxy
    deriving Show

type ExampleSet = '["a", "b"] :: TSet
type ExSet = '[] :: TSet

test1 :: Proxy 'True
test1 = Proxy @(Contains "a" ExampleSet)

test2 :: Proxy '[ "b" ]
test2 = Proxy @(Delete "a" ExampleSet)

test3 :: Proxy 'True
test3 = Proxy @(Contains "num" (Add "num" ExSet))

test4 :: Proxy 'False
test4 = Proxy @(Contains "num" (Delete "num" (Add "num" ExSet)))

main :: IO ()
main = hspec $ do
    describe "type-level set" $ do
        it "if this has been compiled successfully, then it works =D" $ do
            "" `shouldBe` ""
    describe "cht" $ do
        describe "base" $ do
            it "empty" $ do
                cht <- newCHT
                size <- sizeCHT cht
                size `shouldBe` 0
            it "puts make CHT's size bigger" $ do
                cht <- newCHT

                let first = take 100 ['a', 'b' ..]
                let follow = take 100 ['b', 'c' ..]
                let zipped = zip first follow

                forM_ zipped (\(k, v) -> putCHT k v cht)
                size <- sizeCHT cht

                size `shouldBe` 100
                forM_ zipped $ \(k, v) -> do
                    got <- getCHT k cht
                    got `shouldBe` Just v

            it "non-existing key" $ do
                cht <- newCHT

                got :: Maybe Int <- getCHT "test" cht
                got `shouldBe` Nothing
            it "resizing" $ do
                cht <- newCHT

                mapM_ (\a -> putCHT a a cht) (take 16 [1 :: Int, 2 ..])
                buckets <- readTVarConc (chtBuckets cht)
                capacity <- atomically $ getNumElements buckets

                capacity `shouldBe` 2 * initCapacity
        describe "concurrent" $ do
            it "insert & read" $ do
                cht <- newCHT

                let values = take 1000 [1 :: Int, 2 ..]
                replicateConcurrently_ 16 (mapM_ (\a -> putCHT a a cht) values)
                size <- sizeCHT cht
                size `shouldBe` 1000

                replicateConcurrently_ 16 (mapM_ (\a -> do
                    got <- getCHT a cht
                    got `shouldBe` Just a
                    ) values)
