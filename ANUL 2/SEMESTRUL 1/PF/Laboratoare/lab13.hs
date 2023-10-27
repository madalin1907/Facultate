import GHC.Float (sqrtFloat)

{- Monada Maybe este definita in GHC.Base 

instance Monad Maybe where
  return = Just
  Just va  >>= k   = k va
  Nothing >>= _   = Nothing


instance Applicative Maybe where
  pure = return
  mf <*> ma = do
    f <- mf
    va <- ma
    return (f va)       

instance Functor Maybe where              
  fmap f ma = pure f <*> ma   
-}

pos :: Int -> Bool
pos x = x>=0

fct :: Maybe Int ->  Maybe Bool
--fct mx =  mx  >>= (\x -> Just (pos x))
fct mx = do 
  x <- mx
  return (pos x)

addM :: Maybe Int -> Maybe Int -> Maybe Int
-- 2.1
-- addM Nothing Nothing = Nothing
-- addM Nothing (Just x) = Just x
-- addM (Just x) Nothing = Just x
-- addM (Just x) (Just y) = Just (x+y)

-- 2.2
-- addM mx my = mx >>= (\x -> my >>= (\y -> Just (x+y)))
addM mx my = do
  x <- mx
  y <- my
  return (x+y)
-- cartesian_product xs ys = xs >>= ( \x -> (ys >>= \y-> return (x,y)))
cartesian product xs ys = do
  x <- xs
  y <- ys
  return (x,y)
-- prod f xs ys = [f x y | x <- xs, y<-ys]
prod f xs ys = do
  x <- xs
  y <- ys
  return (f x y)

myGetLine :: IO String
-- myGetLine = getChar >>= \x ->
--       if x == '\n' then
--           return []
--       else
--           myGetLine >>= \xs -> return (x:xs)
myGetLine = do
  x <- getChar
  if x == '\n' then
    return []
  else do
    xs <- myGetLine
    return (x:xs)
prelNo noin = sqrt noin
-- prelNo noin = noin >>= sqrt

-- ioNumber = do
--      noin  <- readLn :: IO Float
--      putStrLn $ "Intrare\n" ++ (show noin)
--      let  noout = prelNo noin
--      putStrLn $ "Iesire"
--      print noout
ioNumber = (readLn :: IO Float) >>= \noin -> putStrLn("Intrare\n" ++ show noin) >> let noout = prelNo noin in putStrLn "Iesire\n" >> print noout
data Person = Person { name :: String, age :: Int }

showPersonN :: Person -> String
showPersonN (Person name _) = "NAME: " ++ name
showPersonA :: Person -> String
showPersonA (Person _ age) = "AGE: " ++ show age
{-
showPersonN $ Person "ada" 20
"NAME: ada"
showPersonA $ Person "ada" 20
"AGE: 20"
-}

showPerson :: Person -> String
showPerson x = "(" ++ showPersonN x ++ ", " ++ showPersonA x ++ ")"
{-
showPerson $ Person "ada" 20
"(NAME: ada, AGE: 20)"
-}


newtype Reader env a = Reader { runReader :: env -> a }


instance Monad (Reader env) where
  return x = Reader (\_ -> x)
  ma >>= k = Reader f
    where f env = let a = runReader ma env
                  in  runReader (k a) env

instance Applicative (Reader env) where
  pure = return
  mf <*> ma = do
    f <- mf
    a <- ma
    return (f a)       

instance Functor (Reader env) where              
  fmap f ma = pure f <*> ma    

mshowPersonN :: Reader Person String
mshowPersonN = return "NAME: " >>= \x -> Reader (\(Person name _) -> x ++ name)
mshowPersonA ::  Reader Person String
mshowPersonA = return "AGE: " >>= \x -> Reader (\(Person _ age) -> x ++ show age)
mshowPerson ::  Reader Person String
mshowPerson = mshowPersonN >>= \x -> mshowPersonA >>= \y -> return (x ++ ", " ++ y)
{-
runReader mshowPersonN  $ Person "ada" 20
"NAME:ada"
runReader mshowPersonA  $ Person "ada" 20
"AGE:20"
runReader mshowPerson  $ Person "ada" 20
"(NAME:ada,AGE:20)"
-}