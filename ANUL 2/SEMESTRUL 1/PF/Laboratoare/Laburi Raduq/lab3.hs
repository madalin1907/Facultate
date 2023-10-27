import Data.Char (isDigit, digitToInt)

-- 1
nrVocale :: [String] -> Int
countVowelsInWord :: String -> Int
isVowel :: Char -> Bool

isVowel c = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y'

countVowelsInWord (h:t)
  | null t = val
  | otherwise = val + countVowelsInWord t
  where val = if isVowel h then 1 else 0

nrVocale (h:t)
  | null t = nrv
  | otherwise = nrv + nrVocale t
  where nrv = if reverse h == h then countVowelsInWord h else 0


-- 2
f :: Int -> [Int] -> [Int]
f nr (h:t)
  | null t = possibleTuple
  | otherwise = possibleTuple ++ f nr t
  where possibleTuple = if mod h 2 == 1 then [h] else [h, nr]


-- 3
divizori :: Int -> [Int]
divizori n = [x | x <- [1..n], mod n x == 0]


-- 4
listadiv :: [Int] -> [[Int]]
listadiv l = [k | x <- l, k <- [divizori x]]


-- 5

-- a
inIntervalRec :: Int -> Int -> [Int] -> [Int]
inIntervalRec n m (h:t)
  | null t = val
  | otherwise = val ++ inIntervalRec n m t
  where val = [h | h >= n && h <= m]


-- b
inIntervalComp :: Int -> Int -> [Int] -> [Int]
inIntervalComp n m ls = [x | x <- ls, x >= n && x <= m]


-- 6
pozitiveRec :: [Int] -> Int
pozitiveRec (h:t)
  | null t = val
  | otherwise = val + pozitiveRec t
  where val = if h > 0 then 1 else 0

pozitiveComp :: [Int] -> Int
pozitiveComp ls = length (filter (>0) ls)


-- 7

-- a
pozitiiImpareRec :: [Int] -> Int -> Int -> [Int]
pozitiiImpareRec (h:t) pos total
  | null t = val
  | otherwise = val ++ pozitiiImpareRec t (pos - 1) total
  where val = [total - pos | odd h]


-- b
pozitiiImpareComp :: [Int] -> [Int]
pozitiiImpareComp ls  = [i - 1 | (i, x) <- [1..] `zip` ls, odd x]


-- 8

-- a
multDigitsRec :: String -> Int
multDigitsRec (h:t)
  | null t = val
  | otherwise = val * multDigitsRec t
  where val = if isDigit h then digitToInt h else 1


-- b
multDigitsComp :: String -> Int
multDigitsComp str = product [digitToInt x | x <- str, isDigit x]