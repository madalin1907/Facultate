{-# LANGUAGE DeriveFoldable #-}
data Fruct = Mar String Bool | Portocala String Int

listaFructe = [Mar "Ionatan" False, Portocala "Sanguinello" 10, Portocala "Valencia" 22, Mar "Golden Delicious" True, Portocala "Sanguinello" 15,Portocala "Moro" 12,Portocala "Tarocco" 3,Portocala "Moro" 12,Portocala "Valencia" 2,Mar "Golden Delicious" False,Mar "Golden" False, Mar "Golden" True]

-- 1. a)
ePortocalaDeSicilia :: Fruct -> Bool
ePortocalaDeSicilia (Portocala "Tarocco" _) = True
ePortocalaDeSicilia (Portocala "Moro" _) = True
ePortocalaDeSicilia (Portocala "Sanguinello" _) = True
ePortocalaDeSicilia (Mar _ _) = False
ePortocalaDeSicilia (Portocala _ _) = False

-- b)
nrFeliiSicilia :: [Fruct] -> Int
nrFeliiSicilia [] = 0
nrFeliiSicilia ((Portocala "Tarocco" felii):xs) = felii + nrFeliiSicilia xs
nrFeliiSicilia ((Portocala "Moro" felii):xs) = felii + nrFeliiSicilia xs
nrFeliiSicilia ((Portocala "Sanguinello" felii):xs) = felii + nrFeliiSicilia xs
nrFeliiSicilia ((Portocala _ _):xs) = nrFeliiSicilia xs
nrFeliiSicilia ((Mar _ _):xs) = nrFeliiSicilia xs

-- c)
nrMereViermi :: [Fruct] -> Int
nrMereViermi [] = 0
nrMereViermi ((Portocala _ _):xs) = nrMereViermi xs
nrMereViermi ((Mar _ True):xs) = 1 + nrMereViermi xs
nrMereViermi ((Mar _ False):xs) = nrMereViermi xs

-- 2.
type NumeA = String
type Rasa = String
data Animal = Pisica NumeA | Caine NumeA Rasa
    deriving Show

-- a)
vorbeste :: Animal -> String
vorbeste (Pisica _) = "Meow!"
vorbeste (Caine _ _) = "Woof!"

-- b)
rasa :: Animal -> Maybe String
rasa (Pisica _) = Nothing
rasa (Caine _ race) = Just race

-- 3.
data Linie = L [Int]
    deriving Show
data Matrice = M [Linie]
    deriving Show

-- a)
verifica :: Matrice -> Int -> Bool
verifica (M []) 0 = True
verifica (M []) _ = False
verifica (M (x:xs)) s = sum ((\(L a) -> a) x) == s && verifica (M xs) s
test_veri1 = verifica (M[L[1,2,3], L[4,5], L[2,3,6,8], L[8,5,3]]) 10 == False
test_verif2 = verifica (M[L[2,20,3], L[4,21], L[2,3,6,8,6], L[8,5,3,9]]) 25 == True

-- b)
doarPozN :: Matrice -> Int -> Bool
doarPozN (M [])  _ = True
doarPozN (M (x:xs)) s = 
    if length ((\(L a) -> a) x) == s then
        (\(L l) -> foldr (&&) True [y>0 | y<-l]) x && doarPozN (M xs) s
    else
        doarPozN (M xs) s

testPoz1 = doarPozN (M [L[1,2,3], L[4,5], L[2,3,6,8], L[8,5,3]]) 3 == True
testPoz2 = doarPozN (M [L[1,2,-3], L[4,5], L[2,3,6,8], L[8,5,3]]) 3 == False

-- c)
corect :: Matrice -> Bool
corect (M (x:y:xs)) = 
    length first == length second && corect (M (y:xs))
    where 
        L first = x
        L second = y
corect (M _) = True

testcorect1 = corect (M[L[1,2,3], L[4,5], L[2,3,6,8], L[8,5,3]]) == False
testcorect2 = corect (M[L[1,2,3], L[4,5,8], L[3,6,8], L[8,5,3]]) == True