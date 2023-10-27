import Data.List

myInt = 5555555555555555555555555555555555555555555555555555555555555555555555555555555555555

double :: Integer -> Integer
double x = x+x


--maxim :: Integer -> Integer -> Integer
maxim x y = x > y

max3 x y z = 
     let
          u = maxim x y
     in 
          maxim  u z

max4 x y z t =
     let
          u = max3 x y z
     in
          maxim u t

test_max4 x y z t =
     let
          u = max4 x y z t
     in
          u >= x && u >= y && u >= z && u >= t

-- 6
sumRoot x y = x * x + y * y

evenOrOdd x = if even x then "par" else "impar"
               
factorial x = product [1..x]

compareParameters x y = x > 2 * y