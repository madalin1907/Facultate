-- 1.

data Punct = Pt [Int]

data Arb = Vid | F Int | N Arb Arb
    deriving Show

class ToFromArb a where
    toArb :: a -> Arb
    fromArb :: Arb -> a

-- a)
instance Show Punct where
    show (Pt []) = "()"
    show (Pt (x:xs)) = "(" ++ showsec x xs ++ ")"
        where
            showsec x [] = show x
            showsec x (y:ys) = show x ++ "," ++ showsec y ys

-- b)
instance ToFromArb Punct where
    toArb :: Punct -> Arb
    toArb (Pt []) = Vid
    toArb (Pt (x:xs)) = N (F x) (toArb (Pt xs))
    fromArb :: Arb -> Punct
    fromArb Vid = Pt []
    fromArb (F x) = Pt [x]
    fromArb (N x y) = Pt (l ++ r)
        where
            Pt l = fromArb x
            Pt r = fromArb y

-- 2.
data Geo a = Square a | Rectangle a a | Circle a
    deriving Show

class GeoOps g where
    perimeter :: (Floating a) => g a -> a
    area :: (Floating a) => g a -> a

-- a)
instance GeoOps Geo where
    perimeter :: (Floating a) => Geo a -> a
    perimeter (Square a) = 4 * a
    perimeter (Rectangle a b) = 2 * a + 2 * b
    perimeter (Circle r) = 2 * pi * r

    area :: (Floating a) => Geo a -> a
    area (Square a) = a * a
    area (Rectangle a b) = a * b
    area (Circle r) = pi * r * r

-- b)
instance (Floating a, Eq a) => Eq (Geo a) where
    (==) :: (Floating a, Eq a) => Geo a -> Geo a -> Bool
    x == y = perimeter x == perimeter y