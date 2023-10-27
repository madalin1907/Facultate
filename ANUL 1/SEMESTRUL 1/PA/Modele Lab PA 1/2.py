#a
def deviruseaza(prop):
    cuvinte = prop.split()
    print(cuvinte)
    prop_corecta = []
    for cuv in cuvinte:
        cuvant_corect = cuv[-1] + cuv[1:len(cuv)-1] + cuv[0]
        prop_corecta.append(cuvant_corect)
    prop_corecta.reverse()
    return " ".join(prop_corecta)

#b
def prime(n, numar_maxim = 0):
    nrprime = []
    if n > 2:
        nrprime.append(2)
    for i in range(3, n, 2):
        for divizor in range(2, i//2+1):
            if i % divizor == 0:
                break
        else:
            nrprime.append(i)

    if numar_maxim == 0:
        return nrprime
    else:
        return nrprime[:numar_maxim]

#c
f = open("intrare.in", "r")
g = open("intrare_devirusata.out", "w")

fisier = [prop.rstrip() for prop in f.readlines()]
indici = prime(len(fisier)+1)

for poz in indici:
    fisier[poz-1] = deviruseaza(fisier[poz-1])

for propozitie in fisier:
    g.write(propozitie + "\n")

f.close()
g.close()