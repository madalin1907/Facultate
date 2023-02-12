#a
def citire_matrice(fisier):
    f = open(fisier, "r")
    matrice = [[int(x) for x in linie.split()] for linie in f.readlines()]
    for linie in range(1, len(matrice)):
        if len(matrice[linie]) != len(matrice[0]):
            return None
    return matrice

#b
def multimi(matrice, *p):
    intersectie = set()
    reuniune = set()
    for linie in p:
        neg = set([x for x in matrice[linie] if x < 0])
        poz = set([x for x in matrice[linie] if str(x)[0] == str(x)[-1] and x > 0])

        reuniune = reuniune.union(poz)
        if len(intersectie) ==0:
            intersectie = intersectie.union(neg)
        else:
            intersectie = intersectie.intersection(neg)

    return intersectie, reuniune

#c
matrice = citire_matrice("matrice.in")

nrpoz = multimi(matrice, len(matrice)-1, len(matrice)-2, len(matrice)-3)[1]
print(*nrpoz)

nrneg = multimi(matrice, 0, len(matrice)-1)[0]
print(len(nrneg))
