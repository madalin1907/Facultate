-- 1.
factori :: Integer -> [Integer]
factori x = [d | d<-[1..x `div` 2], x `mod` d == 0] ++ [x]

-- 2.
prim :: Integer -> Bool
prim x = factori x == [1,x]

-- 3.
numerePrime :: Integer -> [Integer]
numerePrime n = [x | x<-[2..n], prim x]

-- 4.
myzip3 :: [a] -> [b] -> [c] -> [(a,b,c)]
myzip3 x y z = [(x !! i, y !! i, z !! i) | i<-[0..]]

-- 5.
firstEl :: [(a,b)] ->[a]
firstEl = map fst

-- 6.
sumList :: [[Int]] -> [Int]
sumList = map sum

-- 7.
pre12 :: [Int] -> [Int]
pre12 = map (\x->if even x then x `div` 2 else x * 2)

-- 8.
inChar :: Char -> [[Char]] -> [[Char]]
inChar c = filter (\x -> c `elem` x)

-- 9.
patrateImp :: [Int] -> [Int]
patrateImp v = map (^2) (filter odd v)

-- 10.
patratePozImp :: [Int] -> [Int]
patratePozImp v = map ((^2) . fst) (filter (even . snd) (zip v [1 .. length v]))

-- 11.
vocale :: [Char] -> [Char]
vocale "" = ""
vocale (h:t) = if h `elem` "aeiouAEIOU" then h:vocale t else vocale t
numaiVocale :: [[Char]] -> [[Char]]
numaiVocale = map vocale

-- 12.
mymap :: (a->b) -> [a] -> [b]
mymap f [] = []
mymap f (h:t) = f h:mymap f t

myfilter :: (a->Bool) -> [a] -> [a]
myfilter f [] = []
myfilter f (h:t) = if f h then h:myfilter f t else myfilter f t 