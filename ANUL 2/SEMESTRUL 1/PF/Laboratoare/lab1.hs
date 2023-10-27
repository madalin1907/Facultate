import Data.List

myInt = 555

double :: Integer -> Integer
double x = x + x

triple x = x + x + x


--maxim :: Integer -> Integer -> Integer
maxim x y = if (x > y)
               then x
            else y


maxim3 x y z = 
     let 
          u = maxim x y
     in 
          maxim u z


-- ex6
sumPatrate x y = x * x + y * y

parImpar :: Integer -> String
parImpar x = if even x then "par" else "impar"

parImpar2 :: Integer -> String
parImpar2 x
     | even x = "par"
     | otherwise = "impar"

factorial :: Integer -> Integer
factorial x = product [1..x]

verify x y
     | x > 2 * y = True
     | otherwise = False
