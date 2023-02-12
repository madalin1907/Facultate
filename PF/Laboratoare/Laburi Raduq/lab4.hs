{-
[ x^2 | x <- [1..10], x `rem` 3 == 2] -- [4, 25, 64]
[(x,y)| x <- [1..5], y <- [x..(x+2)]] -- [(1,1),(1,2),(1,3),(2,2),(2,3),(2,4),(3,3),(3,4),(3,5),(4,4),(4,5),(4,6),(5,5),(5,6),(5,7)]
[(x,y)| x <- [1..3], let k = x^2, y <- [1..k]] -- [(1,1),(2,1),(2,2),(2,3),(2,4),(3,1),(3,2),(3,3),(3,4),(3,5),(3,6),(3,7),(3,8),(3,9)]
[ x | x <- "Facultatea de Matematica si Informatica", elem x ['A'..'Z']] -- FMI
[[x..y] | x <- [1..5], y <- [1..5], x < y] -- [[1,2],[1,2,3],[1,2,3,4],[1,2,3,4,5],[2,3],[2,3,4],[2,3,4,5],[3,4],[3,4,5],[4,5]]
-}

-- 1
factori :: Int -> [Int]
factori n = [x | x <- [1..n], n `mod` x == 0]


-- 2
prim :: Int -> Bool
prim n = length (factori n) == 2


-- 3
numerePrime :: Int -> [Int]
numerePrime n = [x | x <- [2..n], prim x]


-- 4
myzip3 :: [Int] -> [Int] -> [Int] -> [(Int, Int, Int)]
myzip3 l1 l2 l3 = [(x, x, x) | x <- l1, x `elem` l2 && x `elem` l3]


-- 5
firstEl :: [(Char, Int)] -> [Char]
firstEl = map fst


-- 6
sumList :: [[Int]] -> [Int]
sumList = map sum


-- 7
prel2 :: [Int] -> [Int]
prel2 = map (\x -> if even x then x `div` 2 else x * 2)


-- 8
f8 :: Char -> [String] -> [String]
f8 chr = filter (elem chr)


-- 9
f9 :: [Int] -> [Int]
f9 ls = map (* 2) (filter odd ls)


-- 10
f10 :: [Int] -> [Int]
f10 ls = map (\(index, val) -> val * val) (filter (\(index, val) -> odd index) (zip [0..] ls))


-- 11
numaiVocale :: [String] -> [String]
isVowel :: Char -> Bool

isVowel c = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'

numaiVocale = map (filter isVowel)


-- 12
mymap :: (a -> b) -> [a] -> [b]
mymap condition (h:t)
  | null t = mappedVal
  | otherwise = mappedVal ++ mymap condition t
  where mappedVal = [condition h]

myfilter :: (a -> Bool) -> [a] -> [a]
myfilter condition (h:t)
  | null t = filteredVal
  | otherwise = filteredVal ++ myfilter condition t
  where filteredVal = [h | condition h]