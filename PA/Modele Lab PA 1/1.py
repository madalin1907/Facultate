#a
def min_max(lista):
    return min(lista), max(lista)

#b
def incarca_fisier(fisier):
    f = open(fisier, "r")
    numere = [[int(x) for x in y.split()] for y in f.readlines()]
    f.close()
    return numere

#c
nume = input("nume fisier: ")
lista_numere = incarca_fisier(nume)
fout = open("egale.txt", "w")

ok = 0
a = lista_numere[0][0]
b = lista_numere[0][0]

for i in range(len(lista_numere)):
    minim, maxim = min_max(lista_numere[i])
    if minim == maxim:
        fout.write(str(i)+"\n")
        ok = 1
    if minim < a:
        a = minim
    if maxim > b:
        b = maxim

if ok == 0:
    fout.write("Nu exista!")
fout.close()

#SAU
# toatenr = []
# for x in lista_numere:
#     for nr in x:
#         toatenr.append(nr)
#SAU
# toatenr = []
# for x in lista_numere:
#     toatenr.extend(x)
#SAU
# toatenr = [x for nr in lista_numere for x in nr]
#
# a = min(toatenr)
# b = min(toatenr)

print(f"a = {a} si b = {b}")