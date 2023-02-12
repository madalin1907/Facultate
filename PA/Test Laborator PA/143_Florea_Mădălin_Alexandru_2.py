'''
Nume: Florea
Prenume: Mădălin-Alexandru
Grupa: 143

Enunț:
Fișierul "date.in" are n linii cu următoarea structură: pe linia i sunt prezente, separate prin câte un
spațiu, n numere naturale reprezentând elementele de pe linia i dintr-o matrice, ca în exemplu.
Liniile și coloanele unei matrice se presupun numerotate de la 0.
a) [0,25p] Scrieți o funcție citire_matrice care citește numerele din fișierul "date.in" și returnează
o matrice de dimensiuni n x n formată din aceste numere.
b) [1,5p] Scrieți o funcție care primește ca parametri: o matrice, un caracter ch și doi parametri x
și y cu valoare implicită 0.
● Dacă la apel al doilea parametru - caracterul ch primește valoarea "d", funcția nu va
primi decât 2 parametri și trebuie să interschimbe elementele de pe diagonala
principală cu elementele de pe diagonala secundară.
● Dacă la apel al doilea parametru - caracterul ch - primește valoarea "l", funcția va
primi valori și pentru parametrii x, y și trebuie să interschimbe linia x cu linia y.
c) [1,25p] Folosind apeluri ale funcției definite la punctul b), oglindiți matricea returnată de
funcția de la punctul a) după linia de pe poziția [n / 2] și interschimbați elementele de pe
diagonala principală cu cele de pe diagonala secundară. După oglindire și interschimbare, să
se parcurgă matricea în zig-zag pe coloane și să se afișeze șirul obținut în fișierul “date.out”,
ca în exemplu. Se cunoaște faptul că n este impar.
Explicație suplimentară : Parcurgerea în zig-zag pe coloane se va face de la stanga la
dreapta, astfel:
● prima coloană se parcurge de jos în sus,
● a doua coloană se parcurge de sus în jos,
● a treia coloană se parcurge de jos în sus etc.
'''

#a
def citire_matrice():
    f = open("date.in", "r")
    matr = []
    for linie in f.readlines():
        matr.append([int(x) for x in linie.split()])
    f.close()
    return matr


#b
def functie(matr, ch, x=0, y=0):
    if ch == 'l':
        matr[x], matr[y] = matr[y], matr[x]
    elif ch == 'd':
        n = len(matr)
        for i in range(n):
            matr[i][i], matr[i][n-1-i] = matr[i][n-1-i], matr[i][i]

#c
g = open("date.out", "w")
matrice = citire_matrice()
n = len(matrice)

for i in range(n//2 + 1):
    functie(matrice, 'l', i, n-1-i)
functie(matrice, 'd')

for j in range(n):
    if j % 2 == 0:
        for i in range(n-1, -1, -1):
            g.write(str(matrice[i][j]) + " ")
    else:
        for i in range(0, n):
            g.write(str(matrice[i][j]) + " ")
g.close()
