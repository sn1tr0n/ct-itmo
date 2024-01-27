{-# LANGUAGE InstanceSigs #-}
module HW4.T1
  ( EvaluationError (..)
  , ExceptState (..)
  , mapExceptState
  , wrapExceptState
  , joinExceptState
  , modifyExceptState
  , throwExceptState
  , eval
  ) where

import           Control.Monad
import           HW4.Types

newtype ExceptState e s a = ES { runES :: s -> Except e (Annotated s a) }

mapExceptState :: (a -> b) -> ExceptState e s a -> ExceptState e s b
mapExceptState f state = ES (mapping . run)
  where run     = runES state
        mapping = mapExcept $ mapAnnotated f

wrapExceptState :: a -> ExceptState e s a
wrapExceptState x = ES (\s -> Success (x :# s))

joinExceptState :: ExceptState e s (ExceptState e s a) -> ExceptState e s a
joinExceptState (ES state) = ES (injectState . state)
  where
    injectState :: Except e (Annotated s (ExceptState e s a)) -> Except e (Annotated s a)
    injectState (Success ((ES run) :# s)) = run s
    injectState (Error e)                 = Error e

modifyExceptState :: (s -> s) -> ExceptState e s ()
modifyExceptState f = ES (\s -> Success (() :# f s))

throwExceptState :: e -> ExceptState e s a
throwExceptState e = ES (\_ -> Error e)

instance Functor (ExceptState e s) where
  fmap = mapExceptState

instance Applicative (ExceptState e s) where
  pure :: a -> ExceptState e s a
  pure = wrapExceptState
  (<*>) = ap

instance Monad (ExceptState e s) where
  m >>= mapper = joinExceptState $ fmap mapper m

data EvaluationError = DivideByZero
  deriving Show

type ExceptStateD = ExceptState EvaluationError [Prim Double] Double

type UnOpComputer = (Double -> Double)
type PrimUnConstr = (Double -> Prim Double)

type BinOpComputer = (Double -> Double -> Double)
type BinOpTester = (Double -> Double -> Bool)
type PrimBiConstr  = (Double -> Double -> Prim Double)

applyBi :: BinOpComputer -> BinOpTester ->  PrimBiConstr  -> ExceptStateD -> ExceptStateD -> ExceptStateD
applyBi f tester c left right = do
  l <- left
  r <- right
  unless ( tester l r) $ throwExceptState DivideByZero
  modifyExceptState (c l r:)
  return $ f l r

applyUn :: UnOpComputer -> PrimUnConstr -> ExceptStateD -> ExceptStateD
applyUn f c action = do
  value <- action
  modifyExceptState (c value:)
  return $ f value

eval :: Expr -> ExceptStateD
eval (Val x)        = return x
eval (Op operation) = do
  parseOperation operation
  where
    binOp :: BinOpComputer -> PrimBiConstr -> Expr -> Expr -> ExceptStateD
    binOp op constr left right = applyBi op (const . const True) constr (eval left) (eval right)

    binOpTested :: BinOpComputer -> BinOpTester -> PrimBiConstr  -> Expr -> Expr -> ExceptStateD
    binOpTested op constr tester left right = applyBi op constr tester (eval left) (eval right)

    unOp :: UnOpComputer -> PrimUnConstr -> Expr -> ExceptStateD
    unOp op constr action = applyUn op constr (eval action)

    parseOperation :: Prim Expr -> ExceptStateD
    parseOperation (Add x y) = binOp (+) Add x y
    parseOperation (Sub x y) = binOp (-) Sub x y
    parseOperation (Mul x y) = binOp (*) Mul x y
    parseOperation (Div x y) = binOpTested (/) (const . \r -> r /= 0) Div x y
    parseOperation (Abs x)   = unOp  abs Abs x
    parseOperation (Sgn x)   = unOp  signum Sgn x

