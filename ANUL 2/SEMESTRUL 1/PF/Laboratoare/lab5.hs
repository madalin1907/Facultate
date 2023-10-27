-- 1.
sumSquares :: [Int] -> Int
sumSquares l = foldl (+) 0 (map (^2) (filter odd l))

-- 2.
allTrue :: [Bool] -> Bool
allTrue = foldl (&&) True

-- 3.
allVerifies :: (Int -> Bool) -> [Int] -> Bool
allVerifies f l = foldr (&&) True (map f l)

-- 4.
anyVerifies :: (Int -> Bool) -> [Int] -> Bool
anyVerifies f l = foldr (||) False (map f l)

-- 5.
mapFoldr :: (a->b) -> [a] -> [b]
mapFoldr f l = foldr (:) [] [f x | x<-l]

filterFoldr :: (a->Bool) -> [a] -> [a]
filterFoldr f l = foldr (:) [] [x | x<-l, f x]

-- 6.
listToInt :: [Integer] -> Integer
listToInt l = read (foldl (++) "" [show x | x<-l])

-- 7. a)
rmChar :: Char -> String -> String
rmChar c = filter (/=c)

-- b)
rmCharsRec :: String -> String -> String
rmCharsRec a [] = []
rmCharsRec a (x:xs) = if elem x a then rmCharsRec a xs else x : rmCharsRec a xs

-- c)
rmCharsFold :: String -> String -> String
rmCharsFold a b = foldr rmChar b a