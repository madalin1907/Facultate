#a
def litere(*cuvinte):
    dictionar = {}
    for cuv in cuvinte:
        frecv = {}
        for litera in cuv:
            if litera not in frecv:
                frecv[litera] = cuv.count(litera)
        dictionar[cuv] = frecv

    return dictionar

print(litere(*input("Cuvintele: ").split()))


#b
numere = [x for x in range(10, 100) if (x % 2 == 0) and (x % 6 != 0)]
numere = [i for i in range(10, 99, 2) if i % 6 != 0]
print(numere)
















