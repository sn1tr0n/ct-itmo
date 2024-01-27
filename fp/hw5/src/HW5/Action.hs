{-# LANGUAGE DerivingVia  #-}
{-# LANGUAGE InstanceSigs #-}
module HW5.Action
(
    HiPermission(..),
    PermissionException(..),
    HIO(..)

) where
import           Control.Exception          (Exception, throwIO)
import           Control.Monad              (void)
import           Control.Monad.Trans.Reader
import qualified Data.ByteString            as BS
import qualified Data.Sequence              as S
import           Data.Set                   (Set, member)
import           Data.String                (IsString (fromString))
import           Data.Text.Encoding         (decodeUtf8')
import           Data.Time                  (getCurrentTime)
import           HW5.Base                   (HiAction (..), HiMonad (runAction),
                                             HiValue (..))
import           System.Directory           (createDirectory, doesFileExist,
                                             getCurrentDirectory, listDirectory,
                                             setCurrentDirectory)
import           System.Random              (newStdGen, uniformR)


data HiPermission =
    AllowRead
  | AllowWrite
  | AllowTime
  deriving (Enum, Eq, Ord, Show)

newtype PermissionException =
  PermissionRequired HiPermission
  deriving (Eq, Ord, Show)

instance Exception PermissionException

newtype HIO a = HIO { runHIO :: Set HiPermission -> IO a }
  deriving (Functor, Applicative, Monad) via (ReaderT (Set HiPermission) IO)

instance HiMonad HIO where
  runAction :: HiAction -> HIO HiValue
  runAction (HiActionRead path) = HIO $ \permissions ->
    withPermissionCheck AllowRead permissions $ do
      fileExists <- doesFileExist path
      if fileExists
        then do
          content <- BS.readFile path
          return $ case decodeUtf8' content of
            Left _        -> HiValueBytes content
            Right decoded -> HiValueString decoded
        else
          HiValueList . S.fromList . map (HiValueString . fromString) <$> listDirectory path

  runAction (HiActionWrite path content) = HIO $ \permissions ->
    withPermissionCheck AllowWrite permissions $ do
      void $ BS.writeFile path content
      return HiValueNull

  runAction (HiActionMkDir path) = HIO $ \permissions ->
    withPermissionCheck AllowWrite permissions $ do
      void $ createDirectory path
      return HiValueNull

  runAction (HiActionChDir path) = HIO $ \permissions ->
    withPermissionCheck AllowRead permissions $ do
      void $ setCurrentDirectory path
      return HiValueNull

  runAction HiActionCwd = HIO $ \permissions ->
    withPermissionCheck AllowRead permissions $ do
      HiValueString . fromString <$> getCurrentDirectory

  runAction HiActionNow = HIO $ \permissions ->
    withPermissionCheck AllowTime permissions $ do
      HiValueTime <$> getCurrentTime

  runAction (HiActionRand from to) = HIO $ \_ -> do
    generator <- newStdGen
    let (rnd, _) = uniformR (from, to) generator

    return $ HiValueNumber <$> toRational $ rnd

withPermissionCheck :: HiPermission -> Set HiPermission -> IO HiValue -> IO HiValue
withPermissionCheck needed permissions producer = if
  not (member needed permissions)
  then throwIO (PermissionRequired needed)
  else producer
