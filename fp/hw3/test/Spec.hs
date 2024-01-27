

--import HW3.T3(joinList)
import HW3.T4


--test3 :: List (List Int)
--test3 = test2 :. (test1 :. Nil)

test4 :: Expr
test4 = signum ((1 + 2) + 3 - 1000 / 3)

main :: IO ()
main = do
    let a = eval test4
    print $ show $ runS a []
    
