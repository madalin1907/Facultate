import Data.Monoid

elem1 :: (Foldable t, Eq a) => a -> t a -> Bool
elem1 search = foldr cmp False
    where
        cmp x xs
            | x == search = True
            | otherwise = xs

null1 :: (Foldable t) => t a -> Bool
null1 = foldr (\_ _ -> False) True

length1 :: (Foldable t) => t a -> Int
length1 = foldr (\_ b -> 1 + b) 0

toList1 :: (Foldable t) => t a -> [a]
toList1 = foldr (:) []

fold1 :: (Foldable t, Monoid m) => t m -> m
fold1 = foldMap id

data Constant a b = Constant b
data Two a b = Two a b
data Three a b c = Three a b c
data Three' a b = Three' a b b
data Four' a b = Four' a b b b
data GoatLord a = NoGoat | OneGoat a | MoreGoats (GoatLord a) (GoatLord a) (GoatLord a)

instance Foldable (Constant a) where
    foldMap f (Constant b) = f b

instance Foldable (Two a) where
    foldMap f (Two _ b) = f b

instance Foldable (Three a b) where
    foldMap f (Three _ _ c) = f c

instance Foldable (Three' a) where
    foldMap f (Three' _ x y) = f x <> f y

instance Foldable (Four' a) where
    foldMap f (Four' _ x y z) = f x <> f y <> f z

instance Foldable (GoatLord) where
    foldMap f NoGoat = mempty
    foldMap f (OneGoat x) = f x
    foldMap f (MoreGoats x y z) = foldMap f x <> foldMap f y <> foldMap f z