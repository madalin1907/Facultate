#a
def modifica_prefix(x, y, prop):
    nr = 0
    lista = []
    for cuvant in prop.split():
        if cuvant.startswith(x):
            nr += 1
            lista.append(y + cuvant[len(x):])
        else:
            lista.append(cuvant)
    return " ".join(lista), nr

#b
def poz_max(lista):
    poz = []
    maxim = max(lista)
    for i in range(len(lista)):
        if lista[i] == maxim:
            poz.append(i+1)
    return poz

#c
f = open("propozitii.in", "r")
g = open("propozitii_modificate.out", "w")
a, b = input().split()
nrmodif = []
for prop in f:
    x = modifica_prefix(a, b, prop)
    g.write(x[0] + "\n")
    nrmodif.append(x[1])

maxim = max(nrmodif)
for i in range(len(nrmodif)):
    if nrmodif[i] == maxim:
        print(i+1, end = " ")

#sau
#print(*[i+1 for i in range(len(nrmodif)) if nrmodif[i] == maxim])