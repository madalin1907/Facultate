eeny :: Integer -> String
fizzbuzz :: Integer -> String
fibonacciCazuri :: Integer -> Integer
fibonacciCazuri n
    | n < 2     = n
    | otherwise = fibonacciCazuri (n - 1) + fibonacciCazuri (n - 2)
fibonacciEcuational :: Integer -> Integer
fibonacciEcuational 0 = 0
fibonacciEcuational 1 = 1
fibonacciEcuational n =
    fibonacciEcuational (n - 1) + fibonacciEcuational (n - 2)
tribonacci :: Integer -> Integer
binomial :: Integer -> Integer -> Integer
verifL :: [Int] -> Bool
takefinal :: [Int] -> Int -> [Int]
-- semiPareRec [0,2,1,7,8,56,17,18] == [0,1,4,28,9]
semiPareRec :: [Int] -> [Int]
semiPareRec [] = []
semiPareRec (h:t)
 | even h    = h `div` 2 : t'
 | otherwise = t'
 where t' = semiPareRec t
totalLen :: [String] -> Int

poly2 :: Double -> Double -> Double -> Double -> Double
poly2 a b c x = a * x ^ 2 + b * x + c

eeny x = if even x then "eeny" else "meeny"

-- fizzbuzz x =
--     if (mod x 15 == 0)
--         then "FizzBuzz"
--     else if (mod x 3 == 0)
--         then "Fizz"
--     else if (mod x 5 == 0)
--         then "Buzz"
--     else ""

fizzbuzz x
    | mod x 15 == 0 = "FizzBuzz"
    | mod x 3 == 0 = "Fizz"
    | mod x 5 == 0 = "Buzz"
    | otherwise = ""

-- tribonacci n
--     | n <= 2 = 1
--     | n == 3 = 2
--     | otherwise = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3)
    
tribonacci 1 = 1
tribonacci 2 = 1
tribonacci 3 = 2
tribonacci n = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3)    

binomial n k
    | k == 0 = 1
    | n == 0 = 0
    | otherwise = binomial (n - 1) k + binomial (n - 1) (k - 1)

verifL v = even (length v)

takefinal v n
    | length v <= n = v
    | otherwise = drop (length v - n) v

remove :: [Int] -> Int -> [Int]
remove v n
    | n < 0 || n >= length v = v
    | otherwise = take n v ++ drop (n + 1) v

myReplicate :: Int -> Int -> [Int]
myReplicate n v
    | n == 1 = [v]
    | otherwise = myReplicate (n - 1) v ++ [v]
    
sumImp :: [Int] -> Int
sumImp (h:t)
    | null t = ans
    | otherwise = ans + sumImp t
    where ans = if even h then 0 else h

totalLen (h:t)
    | null t = length h
    | otherwise = length h + totalLen t