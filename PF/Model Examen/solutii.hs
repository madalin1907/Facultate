-- Subiectul 2

-- fara monade
getFromInterval a b list = [x | x <- list, a <= x, x <= b]

-- cu monade
getFromIntervalMonade a b list = do 
    x <- list 
    if a <= x && x <= b then return x
    else []






-- Subiectul 1

data Point = Pt [Int]
    deriving Show

data Arb = Empty | Node Int Arb Arb
    deriving Show


class ToFromArb a where
    toArb :: a -> Arb
    fromArb :: Arb -> a


insert :: Int -> Arb -> Arb
insert x Empty = Node x Empty Empty
insert x (Node y l r) 
    | x<=y = Node y (insert x l) r
    | otherwise = Node y l (insert x r) 


instance ToFromArb Point where
    fromArb Empty = Pt[]
    fromArb (Node x l r) = Pt (ll ++ [x] ++ rr)
                        where Pt ll = fromArb l
                              Pt rr = fromArb r   


    toArb (Pt[]) = Empty
    toArb (Pt x) = foldl (flip insert) Empty x






-- Subiectul 3
newtype ReaderWriter env a = RW {getRW :: env-> (a,String)}

instance Monad (ReaderWriter env) where
  return va = RW (\_ -> (va,""))
  ma >>= k = RW f 
      where f env = let (va, str1) = getRW ma env
                        (vb, str2)  = getRW (k va) env
                    in (vb, str1 ++ str2)

instance Applicative (ReaderWriter env) where
  pure = return
  mf <*> ma = do
    f <- mf
    va <- ma
    return (f va)       

instance Functor (ReaderWriter env) where              
  fmap f ma = pure f <*> ma  

 