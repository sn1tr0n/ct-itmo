import HW1.T3(Tree (..)
  , tsize
  , tdepth
  , tmember
  , tinsert
  , tFromList)

import HW1.T1
  ( Day (..)
  , afterDays
  , daysToParty
  , isWeekend
  , nextDay
  ) 

import HW1.T2
  ( N (..)
  , nplus
  , nmult
  , nsub
  , nFromNatural
  , nToNum
  , ncmp
  , nEven
  , nOdd
  , ndiv
  , nmod
  )

one :: Tree Int
one = tinsert 2 Leaf

two :: Tree Int
two = tinsert 1 one

three :: Tree Int
three = tinsert 3 two

four :: Tree Int
four = tinsert 4 three

five :: Tree Int
five = tinsert 5 four

main :: IO ()
main = print $ show $ tFromList [1, 2, 3, 4, 5]