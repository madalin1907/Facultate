data Point = Pt [Int]
    deriving Show

data Arb = Empty | Node Int Arb Arb
    deriving Show


class ToFromArb a where
    toArb :: a -> Arb
    fromArb :: Arb -> a


insert :: Arb -> Int -> Arb
insert Empty x = Node x Empty Empty
insert (Node y l r) x
    | x <= y = Node y (insert l x) r
    | otherwise = Node y l (insert r x)



instance ToFromArb Point where
    toArb (Pt []) = Empty
    toArb (Pt (x:xs)) = foldl insert (Node x Empty Empty) xs

    fromArb Empty = Pt []
    fromArb (Node x l r) = Pt (ll  ++ [x] ++ rr)
        where Pt ll = fromArb l
              Pt rr = fromArb r

----------------------------------------------------

getFromInterval :: Int -> Int -> [Int] -> [Int]
getFromInterval x y ls = [nr | nr <- ls, x <= nr && nr <= y]


getFromIntervalMonad :: Int -> Int -> [Int] -> [Int]
getFromIntervalMonad x y ls = do 
                            nr <- ls
                            if x <= nr && nr <= y then
                                return nr
                            else []

----------------------------------------------------

newtype ReaderWriter env a = RW {getRW :: env-> (a,String)}

instance Monad (ReaderWriter env) where
    return x = RW (\env -> (x,""))
    m >>= f = RW (\env -> let (x,s) = getRW m env
                              (y,t) = getRW (f x) env
                          in (y,s++t))