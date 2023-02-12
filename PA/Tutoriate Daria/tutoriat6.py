# #DICTIONARE
# #ex1
# n = int(input("n="))
# l1 = [x for x in input("lista1: ").split()]
# l2 = [x for x in input("lista2: ").split()]
#
# dict1 = {}
# for i in range(n):
#     dict1.update({l1[i]: l2[i]})
# print(dict1)
# #sau
# dict2 = {}
# for i in range(n):
#     dict2[l1[i]] = l2[i]
# print(dict2)


# #ex2
# dict1 = {"nume": "Ana", "varsta": 30, "salariu": 10000, "oras": "Cluj", "ore": 45}
# lista = {"nume", "salariu", "ore"}
#
# #metoda1
# new_dict1 = {}
# for cheie in lista:
#     if cheie in dict1:
#         new_dict1[cheie] = dict1[cheie]
# print(new_dict1)
#
# #metoda2
# new_dict2 = {}
# for cheie in lista:
#     new_dict2.update({cheie: dict1[cheie]})
# print(new_dict2)
#
# #metoda3
# new_dict3 = {cheie: dict1[cheie] for cheie in lista}
# print(new_dict3)


# #ex3
# #a
# n = int(input("n = "))
# lista = []
# for i in range(n):
#     student = input().split(" ", 1)
#     lista.append((int(student[0]), student[1], i+1))
# print(lista)
#
# #b
# rezultate = {s[0] for s in lista}
# print(rezultate)
#
# #c
# dictionar = {}
# for punctaj in rezultate:
#     dictionar[punctaj] = [(x[1], x[2]) for x in lista if x[0] == punctaj]
# print(dictionar)
#
# #d
# maxim = max(dictionar)
# rez_maxime = dictionar[maxim]
# student = rez_maxime[0]
# print(student)
# #sau direct
# print(dictionar[max(dictionar)][0])


#ex4 PROBLEMA SPIRIDUSI - DICTIONAR DE DICTIONARE
#a
f = open("spiridusi.txt", "r")
dict_spiridusi = {}
for linie in f:
    x = linie.split()
    if x[0] not in dict_spiridusi:
        dict_spiridusi[x[0]] = {}
    if x[2] not in dict_spiridusi[x[0]]:
        dict_spiridusi[x[0]][x[2]] = int(x[1])
    else:
        dict_spiridusi[x[0]][x[2]] += int(x[1])
print(dict_spiridusi)

#b
def ordonareb(lista):
    return -lista[-1], lista[0]

def despre_spiridus(dictionar, cod):
    lista = []
    for jucarie in dictionar[cod]:
        lista.append((jucarie, dictionar[cod][jucarie]))
    lista.sort(key=ordonareb)
    return lista

print(despre_spiridus(dict_spiridusi, 'S1'))

#c
def jucarii(dictionar):
    set_jucarii = set()
    for spiridus in dictionar:
        for jucarie in dictionar[spiridus]:
            set_jucarii.add(jucarie)
    return set_jucarii

set_jucarii = jucarii(dict_spiridusi)
for jucarie in set_jucarii:
    print(jucarie, end=" ")
print()

#d
def ordonared(lista):
    return -lista[1], -lista[2], lista[0]

def spiridusi(dictionar):
    lista = []
    for spiridus in dictionar:
        tipuri_juc = len(dictionar[spiridus])
        nr_juc = sum([dictionar[spiridus][x] for x in dictionar[spiridus]])
        lista.append((spiridus, tipuri_juc, nr_juc))
    lista.sort(key=ordonared)
    return lista

print(spiridusi(dict_spiridusi))

#e
def actualizare(dictionar, cod, jucarie):
    if len(dictionar[cod]) >= 2:
        dictionar[cod].pop(jucarie)
        return True
    else:
        return False

actualizare(dict_spiridusi, 'S1', 'trenulet')
print(despre_spiridus(dict_spiridusi, 'S1'))
