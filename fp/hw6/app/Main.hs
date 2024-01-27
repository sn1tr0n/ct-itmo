import           Control.Exception   (Exception, throwIO)
import           Control.Monad       (forM_, unless)
import           Data.Grid           (Grid (unGrid))
import           Data.ListZipper     (toList)
import           HW6.T3              (Cell (..), Comonad19Grid, Config (..),
                                      simulate)
import           Options.Applicative
import           Prettyprinter

data CLIOptions = CLI
    { prob       :: Double
    , inc        :: Int
    , ill        :: Int
    , immun      :: Int
    , gridSize   :: Int
    , iterations :: Int
    , seed       :: Int
    }

newtype ConfiguringException = ConfiguringException String
    deriving Show
instance Exception ConfiguringException

main :: IO ()
main = do
    cliOptions <- execParser optionsParser
    validateCLIOptions cliOptions

    let config = mapCLIOptionsToConfig cliOptions
    let simulation = simulate config (seed cliOptions)
    let iter = iterations cliOptions
    let indexed = zip [1..iter] (take iter simulation)
    
    forM_ indexed $ \(index, grid) -> do
        putStrLn $ "iteration " ++ show index ++ "/" ++ show iter ++ ":"

        let cells = getCells (gridSize cliOptions) grid
        print $ printFramedMatrix (gridSize cliOptions) cells

        putStrLn "\n\n\n"
  where
    mapCLIOptionsToConfig :: CLIOptions -> Config
    mapCLIOptionsToConfig cli = Config {
        probability = prob cli,
        incubationPeriod = inc cli,
        illnessDuration = ill cli,
        immunityDuration = immun cli
    }

validateCLIOptions :: CLIOptions -> IO ()
validateCLIOptions cli = do
    let p = prob cli
    unless (0 <= p && p <= 1) $ throwIO $ ConfiguringException "infection probability must be in [0, 1]"

    assertPositive (inc cli) "incubation period"
    assertPositive (ill cli) "illness duration"
    assertPositive (immun cli) "immunity duration"
    assertPositive (gridSize cli) "grid size"
    assertPositive (iterations cli) "iterations count"
    assertPositive (seed cli) "seed"

  where
    assertPositive :: Int -> String -> IO ()
    assertPositive n name = unless (0 < n) $ throwIO $ ConfiguringException (name ++ " must be positive")

getCells :: Int -> Comonad19Grid -> [[Cell]]
getCells n grid = toList n <$> fmap (toList n) unGrid grid

printFramedMatrix :: Int -> [[Cell]] -> Doc ann
printFramedMatrix n matrix = vcat
  [ topLeftCorner <+> horizontalLine <+> topRightCorner
  , vcat [border <+> hcat (map pretty row) <+> border | row <- matrix]
  , bottomLeftCorner <+> horizontalLine <+> bottomRightCorner
  ]
  where
    topLeftCorner = pretty "┌"
    topRightCorner = pretty "┐"
    bottomLeftCorner = pretty "└"
    bottomRightCorner = pretty "┘"
    border = pretty "┆"
    horizontalLine = hcat $ replicate (2 * n + 1) $ pretty "╌"

optionsParser :: ParserInfo CLIOptions
optionsParser =
    info
        (helper <*> version <*> options)
        (fullDesc <> progDesc "comonad19" <>
            header
                "comonad19 - infection CLI simulator based on comonads")

version :: Parser (a -> a)
version = infoOption "1.0.0" (long "version" <> help "Show version")

options :: Parser CLIOptions
options =
    CLI
    <$>
        option auto
        ( long "prob"
        <> help "Infection probability")
    <*> option auto
        ( long "incub"
        <> help "Incubation period duration")
    <*> option auto
        ( long "ill"
            <> help "Illness duration")
    <*> option auto
        ( long "immun"
            <> help "Immunity duration")
    <*> option auto
        (long "grid-size"
            <> help "Output grid size (one side, resulting h = w = 2 * gs + 1)")
    <*> option auto
        ( long "iterations"
            <> help "The number of simulation iterations")
    <*> option auto
        ( long "seed"
            <> value 1531
            <> help "Initial seed for random")
