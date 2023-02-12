import GHC.Exts.Heap (GenClosure(value))

data Expr = Const Int -- integer constant
            | Expr :+: Expr -- addition
            | Expr :*: Expr -- multiplication

data Operation = Add | Mult deriving (Eq, Show)

data Tree = Lf Int -- leaf
    | Node Operation Tree Tree -- branch
    deriving (Eq, Show)

-- 1.1
instance Show Expr where
    show :: Expr -> String
    show (Const i) = show i
    show (a :+: b) = "(" ++ show a ++ "+" ++ show b ++ ")"
    show (a :*: b) = "(" ++ show a ++ "*" ++ show b ++ ")"

-- 1.2
evalExp :: Expr -> Int
evalExp (Const x) = x
evalExp (x1 :+: x2) = evalExp x1 + evalExp x2
evalExp (x1 :*: x2) = evalExp x1 * evalExp x2

-- 1.3
evalArb :: Tree -> Int
evalArb (Lf x) = x
evalArb (Node Add a b) = evalArb a + evalArb b
evalArb (Node Mult a b) = evalArb a * evalArb b

-- 1.4
expToArb :: Expr -> Tree
expToArb (Const x) = Lf x
expToArb (x1 :+: x2) = Node Add (expToArb x1) (expToArb x2)
expToArb (x1 :*: x2) = Node Mult (expToArb x1) (expToArb x2)


-- 2
class Collection c where
    empty :: c key value
    singleton :: key -> value -> c key value
    insert :: Ord key => key -> value -> c key value -> c key value
    clookup :: Ord key => key -> c key value -> Maybe value
    delete :: Ord key => key -> c key value -> c key value
    keys :: c key value -> [key]
    values :: c key value -> [value]
    toList :: c key value -> [(key, value)]
    fromList :: Ord key => [(key,value)] -> c key value
-- 2.1
    keys c = [fst x | x<-toList c]
    values c = [snd x | x<- toList c]
    fromList [] = empty
    fromList ((key, value):xs) = insert key value $ fromList xs

-- 2.2
newtype PairList k v 
    = PairList { getPairList :: [(k, v)] }

instance Collection PairList where
    empty :: PairList key value
    empty = PairList []
    singleton :: key -> value -> PairList key value
    singleton k v = PairList [(k,v)]
    clookup k p = lookup k (getPairList p)
    insert k v (PairList l) = PairList (a, b): filter(\(k,v) -> k/=a) l
    delete a (PairList l) = PairList $ filter(\(k,v) -> k/=a) l

-- 2.3
data SearchTree key value
    = Empty
    | BNode
        (SearchTree key value) -- elemente cu cheia mai mica
        key -- cheia elementului
        (Maybe value) -- valoarea elementului
        (SearchTree key value) -- elemente cu cheia mai mare

instance Collection SearchTree where
    empty :: SearchTree key value
    empty = Empty
    singleton k v = BNode Empty k (Just v) Empty
    insert k v Empty = singleton k v
    insert k v (BNode t1 k1 v1 t2) 
        | k < k1 = BNode (insert k v t1) k1 v1 t2
        | k > k1 = BNode t1 k1 v1 (insert k v t2)
        | otherwise = BNode t1 k (Just v) t2
    clookup key (BNode t1 k v t2)
        | key < k = clookup key t1
        | key > k = clookup key t2
        | otherwise = v
    delete key (BNode t1 k v t2)
        | key < k = delete key t1
        | key > k = delete key t2
        | otherwise = BNode t1 k Nothing t2
    toList Empty = []
    toList (BNode t1 k Nothing t2) = toList t1 ++ toList t2
    toList (BNode t1 k (Just v) t2) = [(k,v)] ++ toList t1 ++ toList t2
    fromList [] = Empty
    fromList ((k,v):xs1:xs2) = BNode (fromList xs1) k v (fromList xs2) 