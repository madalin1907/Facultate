#a
def cifra_control(n):
    s = 0
    while n != 0:
        s += n % 10
        n //= 10
    if s <= 9:
        return s
    else:
        return cifra_control(s)

#b
def insereaza_cifra_control(lista):
    for i in range(len(lista)):
        lista.insert(2*i+1, cifra_control(lista[2*i]))

#c
def egale(*liste):
    for lista in liste:
        if lista != liste[0]:
            return False
    return True

#d
f = open("numere.in", "r")
numere = [int(x) for x in f.readline().split()]
f.close()

insereaza_cifra_control(numere)

for i in range(len(numere)//2):
    print(numere[2*i], numere[2*i+1], sep=" ")

#e
f1 = open("numere.in", "r")
f2 = open("numere2.in", "r")

lista1 = (int(x) for x in f1.read().split())
lista2 = (int(x) for x in f2.read().split())

f1.close()
f2.close()

set1 = set(lista1)
set2 = set(lista2)

lista1 = list(set1)
lista2 = list(set2)

lista1.sort()
lista2.sort()

insereaza_cifra_control(lista1)
insereaza_cifra_control(lista2)

cif1 = [lista1[i] for i in range(1, len(lista1), 2)]
cif2 = [lista2[i] for i in range(1, len(lista2), 2)]

if (egale(cif1, cif2)):
    print("da")
else:
    print("nu")