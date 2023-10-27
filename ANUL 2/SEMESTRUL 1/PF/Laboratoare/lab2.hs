-- 1.
poly2 :: Double -> Double -> Double -> Double -> Double
poly2 a b c x = a*x^2+b*x+c


-- 2.
eeny :: Integer -> String
eeny x = if even x then "eeny" else "meeny"


-- 3.
fizzbuzz :: Integer -> String
fizzbuzz x = if mod x 15 == 0 then "FizzBuzz"
             else if mod x 3 == 0 then "Fizz" 
             else if mod x 5 == 0 then "Buzz" 
             else ""

-- fizzbuzz x
--        | mod x 15 == 0 = "FizzBuzz"
--        | mod x 3 == 0 = "Fizz"
--        | mod x 5 == 0 = "Buzz"
--        | otherwise = ""


-- 4.
tribonacci :: Integer -> Integer
tribonacci 1 = 1
tribonacci 2 = 1
tribonacci 3 = 2
tribonacci n = tribonacci (n-1) + tribonacci (n-2) + tribonacci (n-3)


-- 5.
binomial :: Integer -> Integer -> Integer
binomial _ 0 = 1
binomial 0 _ = 1
binomial n k = binomial (n-1) k + binomial (n-1) (k-1)


-- 6. a)
verifL :: [Integer] -> Bool
verifL x = even (length x)


-- b)
takefinal :: [Int] -> Int -> [Int]
takefinal x n = if length x == n then x 
                else takefinal (tail x) n 


-- c)
remove :: [Int] -> Int -> [Int]
remove x n
    | n < 0 || n >= length x = x
    | otherwise = take n x ++ drop (n + 1) x


-- 7. a)
myreplicate :: Integer -> a -> [a]
myreplicate n a = [a | x <- [1..n]]

-- myreplicate n v
--     | n == 0 = []
--     | otherwise = myreplicate (n - 1) v ++ [v]



-- b)
sumImp :: [Integer] -> Integer
sumImp xs = sum [x | x <- xs, mod x 2 == 1]

-- c)
totalLen :: [String] -> Int
totalLen xs = sum [length x | x <- xs, head x == 'A']

