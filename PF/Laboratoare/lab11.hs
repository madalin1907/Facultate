data List a = Nil
            | Cons a (List a)
    deriving (Eq, Show)

(+++) :: List a -> List a -> List a
(Cons x xs) +++ Nil = Cons x xs
(Cons x xs) +++ ls = Cons x (xs +++ ls)
Nil +++ b = b 

instance Functor List where
    fmap f Nil = Nil
    fmap f (Cons x y) = Cons (f x) (fmap f y)

instance Applicative List where
    pure x = Cons x Nil
    (<*>) :: List (a -> b) -> List a -> List b
    (<*>) Nil _ = Nil
    (<*>) (Cons f lf) x = (fmap f x) +++ (lf <*> x)

data Cow = Cow {
    name :: String
    , age :: Int
    , weight :: Int
    } deriving (Eq, Show)

noEmpty :: String -> Maybe String
noEmpty "" = Nothing
noEmpty x = Just x

noNegative :: Int -> Maybe Int
noNegative x = if x<0 then Nothing else Just x

cowFromString :: String -> Int -> Int -> Maybe Cow
cowFromString n v g = if noEmpty n /= Nothing && noNegative v /= Nothing && noNegative g /= Nothing then Just Cow{name=n, age = v, weight = g} else Nothing

cowFromString1 n v g = Cow <$> noEmpty n <*> noNegative v <*> noNegative g