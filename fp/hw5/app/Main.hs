module Main (main) where
import HW5.Base(HiError, HiValue)
import HW5.Action(HIO (runHIO), HiPermission (AllowRead, AllowWrite, AllowTime))
import HW5.Parser
import HW5.Pretty
import HW5.Evaluator
import System.Console.Haskeline
import Control.Monad.IO.Class (liftIO)
import Data.Set

main :: IO ()
main = runInputT defaultSettings loop

loop :: InputT IO ()
loop = do
    minput <- getInputLine "hi> "
    case minput of
        Just "q" -> outputStrLn "bye!"
        Just command -> do
            case parse command of
                Right expr -> do 
                    -- debug output -- outputStrLn $ show expr
                    let evaluator = eval expr :: HIO (Either HiError HiValue)
                    result <- liftIO $ runHIO evaluator (fromList [AllowRead, AllowWrite, AllowTime])
                    outputStrLn $ case result of 
                        Left e -> show e
                        Right value -> show $ prettyValue value 
                Left e -> outputStrLn $ show e
            loop
        Nothing -> 
            outputStrLn "got nothing from haskeline :()"
