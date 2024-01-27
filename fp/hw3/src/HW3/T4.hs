module HW3.T4
  ( State (..)
  , Prim (..)
  , Expr (..)
  , mapState
  , wrapState
  , joinState
  , modifyState
  , eval
  ) where

import           HW3.T1

newtype State s a = S { runS :: s -> Annotated s a }

mapState :: (a -> b) -> State s a -> State s b
mapState f state = S (mapping . run)
  where run     = runS state
        mapping = mapAnnotated f

wrapState :: a -> State s a
wrapState x = S (x :#)

joinState :: State s (State s a) -> State s a
joinState (S state) = S (injectState . state)
  where
    injectState :: Annotated s (State s a) -> Annotated s a
    injectState ((S run):#s) = run s

modifyState :: (s -> s) -> State s ()
modifyState f = S (\s -> () :# f s)

instance Functor (State s) where
  fmap = mapState

instance Applicative (State s) where
  pure = wrapState
  S runMap <*> mappingState = S (\s -> injectState (runMap s) mappingState)
    where
      injectState :: Annotated s (a -> b) -> State s a -> Annotated s b
      injectState (mapper :# s) oldState = runS (mapState mapper oldState) s

instance Monad (State s) where
  m >>= mapper = joinState $ fmap mapper m

data Prim a =
    Add a a
  | Sub a a
  | Mul a a
  | Div a a
  | Abs a
  | Sgn a
  deriving Show

data Expr = Val Double | Op (Prim Expr)
  deriving Show

instance Num Expr where
  a + b         = Op (Add a b)
  a - b         = Op (Sub a b)
  a * b         = Op (Mul a b)
  abs x         = Op (Abs x)
  signum x      = Op (Sgn x)
  fromInteger x = Val $ fromInteger x

instance Fractional Expr where
  a / b = Op (Div a b)
  fromRational x = Val $ fromRational x

type StateD = State [Prim Double] Double

type UnOpComputer = (Double -> Double)
type PrimUnConstr = (Double -> Prim Double)

type BinOpComputer = (Double -> Double -> Double)
type PrimBiConstr  = (Double -> Double -> Prim Double)

applyBi :: BinOpComputer -> PrimBiConstr -> StateD -> StateD -> StateD
applyBi f c left right = do
  l <- left
  r <- right
  modifyState (c l r:)
  return $ f l r

applyUn :: UnOpComputer -> PrimUnConstr -> StateD -> StateD
applyUn f c action = do
  value <- action
  modifyState (c value:)
  return $ f value

eval :: Expr -> StateD
eval (Val x)        = return x
eval (Op operation) = do
  parseOperation operation
  where
    binOp :: BinOpComputer -> PrimBiConstr -> Expr -> Expr -> StateD
    binOp op constr left right = applyBi op constr (eval left) (eval right)

    unOp :: UnOpComputer -> PrimUnConstr -> Expr -> StateD
    unOp op constr action = applyUn op constr (eval action)

    parseOperation :: Prim Expr -> StateD
    parseOperation (Add x y) = binOp (+) Add x y
    parseOperation (Sub x y) = binOp (-) Sub x y
    parseOperation (Mul x y) = binOp (*) Mul x y
    parseOperation (Div x y) = binOp (/) Div x y
    parseOperation (Abs x)   = unOp  abs Abs x
    parseOperation (Sgn x)   = unOp  signum Sgn x

