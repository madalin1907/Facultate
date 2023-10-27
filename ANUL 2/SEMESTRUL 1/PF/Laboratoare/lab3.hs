import Data.Char



-- 1.
calculVocale :: String -> Int
calculVocale [] = 0
calculVocale (x:xs) = if x `elem` ['a','e','i','o','u'] then 1 + calculVocale xs else calculVocale xs;

nrVocale :: [String] -> Int
nrVocale [] = 0
nrVocale (x:xs) = if x == reverse x then calculVocale x + nrVocale xs else nrVocale xs;



-- 2.
f :: Int -> [Int] -> [Int]
f _ [] = []
f x (h:t) = if even h then [h] ++ [x] ++ f x t else [h] ++ f x t



-- 3.
divizori :: Int -> [Int]
divizori x = [d | d <- [1..x], mod x d == 0]



-- 4.
listadiv :: [Int] -> [[Int]]
listadiv l = [k | x <- l, k <- [divizori x]]



-- 5. a)
inIntervalRec :: Int -> Int -> [Int] -> [Int]
inIntervalRec n m (h:t)
    | null t = val
    | otherwise = val ++ inIntervalRec n m t
    where val = [h | h >= n && h <= m]



-- b)
inIntervalComp :: Int -> Int -> [Int] -> [Int]
inIntervalComp x y ls = [i | i <- ls, i `elem` [x..y]]



-- 6. a)
pozitiveComp :: [Int] -> Int
pozitiveComp ls = length [x | x <- ls, x > 0]



-- b)
pozitiveRec :: [Int] -> Int
pozitiveRec [] = 0
pozitiveRec (h:t) = if h > 0 then 1 + pozitiveRec t else pozitiveRec t



-- 7. b)
pozitiiImpareComp :: [Int] -> [Int]
pozitiiImpareComp ls = [i | i <- [0..length ls - 1], not (even (ls !! i))]



-- 8. a)
multiDigitsRec :: String -> Int
multiDigitsRec "" = 1
multiDigitsRec (h:t) = if isDigit h then digitToInt h * multiDigitsRec t
 else multiDigitsRec t



-- b)
multiDigitsComp :: String -> Int
multiDigitsComp str = product [digitToInt x | x <- str, isDigit x]