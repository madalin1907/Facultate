data Fruct
  = Mar String Bool
  | Portocala String Int

ionatanFaraVierme = Mar "Ionatan" False
goldenCuVierme = Mar "Golden Delicious" True
portocalaSicilia10 = Portocala "Sanguinello" 10
listaFructe = [Mar "Ionatan" False,
                Portocala "Sanguinello" 10,
                Portocala "Valencia" 22,
                Mar "Golden Delicious" True,
                Portocala "Sanguinello" 15,
                Portocala "Moro" 12,
                Portocala "Tarocco" 3,
                Portocala "Moro" 12,
                Portocala "Valencia" 2,
                Mar "Golden Delicious" False,
                Mar "Golden" False,
                Mar "Golden" True]

test_ePortocalaDeSicilia1 =
    ePortocalaDeSicilia (Portocala "Moro" 12) == True
test_ePortocalaDeSicilia2 =
    ePortocalaDeSicilia (Mar "Ionatan" True) == False

test_nrFeliiSicilia = nrFeliiSicilia listaFructe == 52

test_nrMereViermi = nrMereViermi listaFructe == 2

type NumeA = String
type Rasa = String
data Animal = Pisica NumeA | Caine NumeA Rasa
    deriving Show


data Linie = L [Int]
   deriving Show
data Matrice = M [Linie]
   deriving Show


test_verif1 = verifica (M[L[1,2,3], L[4,5], L[2,3,6,8], L[8,5,3]]) 10 == False
test_verif2 = verifica (M[L[2,20,3], L[4,21], L[2,3,6,8,6], L[8,5,3,9]]) 25 == True

testPoz1 = doarPozN (M [L[1,2,3], L[4,5], L[2,3,6,8], L[8,5,3]]) 3 == True

testPoz2 = doarPozN (M [L[1,2,-3], L[4,5], L[2,3,6,8], L[8,5,3]]) 3 == False

testcorect1 = corect (M[L[1,2,3], L[4,5], L[2,3,6,8], L[8,5,3]]) == False
testcorect2 = corect (M[L[1,2,3], L[4,5,8], L[3,6,8], L[8,5,3]]) == True


-- 1
-- a
ePortocalaDeSicilia :: Fruct -> Bool
ePortocalaDeSicilia (Mar _ _) = False
ePortocalaDeSicilia (Portocala soi _)
    | soi == "Tarocco" || soi == "Moro" || soi == "Sanguinello" = True
    | otherwise = False


-- b
nrFeliiPortocala :: Fruct -> Int
nrFeliiPortocala (Portocala _ felii) = felii

nrFeliiSicilia :: [Fruct] -> Int
nrFeliiSicilia = foldr (\x y -> if ePortocalaDeSicilia x then y + nrFeliiPortocala x else y) 0


-- c
eMar :: Fruct -> Bool
eMar (Mar _ _) = True
eMar (Portocala _ _ ) = False

areMarViermi :: Fruct -> Bool
areMarViermi (Mar _ nr) = nr

nrMereViermi :: [Fruct] -> Int
nrMereViermi = foldr (\x y -> if eMar x && areMarViermi x then y + 1 else y) 0


-- 2
-- a
vorbeste :: Animal -> String
vorbeste (Pisica _) = "Meow!"
vorbeste (Caine _ _) = "Woof!"


-- b
rasa :: Animal -> Maybe String
rasa (Pisica _) = Nothing
rasa (Caine _ rasa) = Just rasa


-- 3
-- a
sumaLinie :: Linie -> Int
sumaLinie (L linie) = sum linie

verifica :: Matrice -> Int -> Bool
verifica (M matrix) n = foldr (\x y -> if sumaLinie x == n then y + 1 else y) 0 matrix == length matrix


-- b
elemPozLinie :: Linie -> Bool
elemPozLinie (L linie) = foldr (\x y -> if x > 0 then y + 1 else y) 0 linie == length linie

countLiniiLungimeN :: Matrice -> Int -> Int
countLiniiLungimeN (M matrix) n = foldr (\(L x) y -> if length x == n then y + 1 else y) 0 matrix

doarPozN :: Matrice -> Int -> Bool
doarPozN (M matrix) n = foldr (\(L x) y -> if length x == n && elemPozLinie (L x) then y + 1 else y) 0 matrix == countLiniiLungimeN (M matrix) n


-- c
corect :: Matrice -> Bool
corect (M (x:y:lines)) = 
    if length first == length second
        then True && corect (M (y:lines))
        else False 
    where 
        first = (\(L x) -> x) x
        second = (\(L y) -> y) y