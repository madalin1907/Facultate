import Data.Char
-- 1
f1 :: [Int] -> Int
-- f1 ls = foldl (+) 0 (map (\x -> x * x) (filter odd ls))
f1 ls = sum (map (\x -> x * x) (filter odd ls))


-- 2
f2 :: [Bool] -> Bool
-- f2 ls = (foldr (+) 0 (map (\x -> if x then 1 else 0) ls)) == length ls
f2 ls = sum (map (\x -> if x then 1 else 0) ls) == length ls


-- 3
allVerifies :: (Int -> Bool) -> [Int] -> Bool
-- allVerifies cond ls = foldr (+) 0 (map (\x -> if cond x then 1 else 0) ls) == length ls
allVerifies cond ls = sum (map (\x -> if cond x then 1 else 0) ls) == length ls


-- 4
anyVerifies :: (Int -> Bool) -> [Int] -> Bool
-- anyVerifies cond ls = foldr (+) 0 (map (\x -> if cond x then 1 else 0) ls ) >= 1
anyVerifies cond ls = sum (map (\x -> if cond x then 1 else 0) ls ) >= 1


-- 5
mapFoldr :: forall a b. (a -> b) -> [a] -> [b]
mapFoldr cond = foldr (\x xs -> cond x : xs) []

filterFoldr :: forall a b. (a -> Bool) -> [a] -> [a]
filterFoldr cond = foldr (\x xs -> if cond x then x : xs else xs) []


-- 6
listToInt :: [Int] -> Int
listToInt = foldl (\x y -> 10 * x + y) 0


-- 7
-- a
rmChar :: Char -> String -> String
rmChar chr = filter (\x -> x > chr || x < chr)


-- b
rmCharsRec :: String -> String -> String
rmCharsRec (h:t) str2
  | t == "" = val
  | otherwise = rmCharsRec t val
  where val = rmChar h str2


-- c
rmCharsFold :: String -> String -> String
rmCharsFold str1 = foldr (\x y -> if x `elem` str1 then y else x : y) ""