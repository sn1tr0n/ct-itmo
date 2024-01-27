module HW6.T3
  ( Config (..)
  , Cell (..)
  , CellState (..)
  , Comonad19Grid

  , simulate
  ) where

import           System.Random   (Random (randomR), RandomGen (split), StdGen,
                                  mkStdGen)

import           Control.Comonad (Comonad (duplicate, extend, extract))
import           Control.Monad   (liftM2)
import           Data.Function   ((&))
import           Data.Grid       (Grid (..), down, gridWrite, left, right, up)
import           Data.ListZipper (ListZipper (LZ))
import           Prettyprinter   (Pretty (..))

-- | Configuration record
data Config = Config
  { probability      :: Double
  , incubationPeriod :: Int
  , illnessDuration  :: Int
  , immunityDuration :: Int
  } deriving Show

-- | Cell state type
data CellState
  = Healthy
  | Infected Int
  | Ill Int
  | Immune Int
  deriving Show

type CellStateConstr = Int -> CellState

-- | Cell record
data Cell = Cell
  { cellState :: CellState
  , cellRand  :: StdGen
  }

instance Pretty Cell where
  pretty (Cell Healthy _)      = pretty "_"
  pretty (Cell (Infected _) _) = pretty "i"
  pretty (Cell (Ill _) _)      = pretty "#"
  pretty (Cell (Immune _) _)   = pretty "@"

-- | Comonad grid type
type Comonad19Grid = Grid Cell

-- | Creates an infinite list of grids using the given configuration and seed (for RNG).
-- Each element of this list represents one infection simulation step.
simulate :: Config -> Int -> [Comonad19Grid]
simulate config seed = do
  let grid = baseSituation seed
  iterate (extend (rule config)) grid

rule :: Config -> Comonad19Grid -> Cell
rule config grid = case cellState cell of
  Healthy -> do
    let (isInfected, newGen) = isInfectedToday

    Cell {
      cellState = if isInfected then Infected 0 else Healthy,
      cellRand = newGen
    }
  Infected days -> nextState days (incubationPeriod config) Infected Ill
  Ill days -> nextState days (illnessDuration config) Ill Immune
  Immune days -> nextState days (immunityDuration config) Immune (const Healthy)

  where
    cell :: Cell
    cell = extract grid

    currentGen :: StdGen
    currentGen = cellRand cell

    neighbours :: [Cell]
    neighbours = extract . (grid &) <$> dirs
      where horizontals = [left, right]
            verticals   = [up, down]
            dirs = horizontals ++ verticals ++ liftM2 (.) horizontals verticals

    isInfectedToday :: (Bool, StdGen)
    isInfectedToday = do
      let (p, newerGen) = randomR (0, 1) currentGen
      let count = fromIntegral $ length $ filter canInfect neighbours
      let neighboursProb = 1.0 - (1.0 - probability config) ** count

      (p < neighboursProb, newerGen)

    canInfect :: Cell -> Bool
    canInfect c = case cellState c of
      (Infected _) -> True
      (Ill _)      -> True
      _            -> False

    nextState :: Int -> Int -> CellStateConstr -> CellStateConstr -> Cell
    nextState days threshold cur next = Cell {
      cellState = if days == threshold then next 0 else cur (days + 1),
      cellRand = currentGen
    }

baseSituation :: Int -> Comonad19Grid
baseSituation seed = do
  let startTuple@(mGen, rGen) = split $ mkStdGen seed
  let (lGen, lmGen) = split mGen -- preparing start random states

  let lz = LZ (stdGenStream (split lGen)) startTuple (stdGenStream (split rGen))
  let cells = fmap (Cell Healthy . fst) lz
  let grid = Grid (duplicate cells)
  let infectedCell = Cell (Infected 0) lmGen

  gridWrite infectedCell grid

  where
    stdGenStream :: (StdGen, StdGen) -> [(StdGen, StdGen)]
    stdGenStream = iterate (split . snd)

