#1. 
class NodArbore:
    def __init__(self, info, parinte = None):
        self.info = info
        self.parinte = parinte

    def drumRadacina(self):
        l = []
        nod = self
        while nod is not None:
            l.insert(0, nod)
            nod = nod.parinte
        return l

    def vizitat(self):
        nod = self.parinte
        while nod is not None:
            if nod.info == self.info:
                return True
            nod = nod.parinte
        return False

    def __repr__(self):
        return "{} ({})".format(self.info, "->".join([str(x) for x in self.drumRadacina()]))

    def __str__(self):
        return str(self.info)

    def afisSolFisier(self, numeFisier): # ex 3 (tema)
        drum = self.drumRadacina()
        with open(numeFisier, "w") as f:
            for pas in drum:
                solutie = ""

                stanga = "(Stanga:<barca>) " if pas.info[2] == 1 else "(Stanga) "
                canibaliMalStang = pas.info[1]
                misionariMalStang = pas.info[0]
                malStang = stanga + str(canibaliMalStang) + " canibali " + str(misionariMalStang) + " misionari"

                dreapta = " ...... (Dreapta:<barca>) " if pas.info[2] == 0 else " ...... (Dreapta) "
                canibaliMalDrept = Graf.N - canibaliMalStang
                misionariMalDrept = Graf.N - misionariMalStang
                malDrept = dreapta + str(canibaliMalDrept) + " canibali " + str(misionariMalDrept) + " misionari"

                deplasare = ""
                predecesor = pas.parinte
                if predecesor is not None:
                    directieBarca = pas.info[2]

                    deplasare += "\n\n>>> Barca s-a deplasat de la malul "
                    deplasare += "stang la malul drept cu " if directieBarca == 0 else "drept la malul stang cu "

                    canibaliBarca = abs(predecesor.info[1] - canibaliMalStang)
                    misionariBarca = abs(predecesor.info[0] - misionariMalStang)

                    deplasare += str(canibaliBarca) + " canibali si " + str(misionariBarca) + " misionari.\n"

                solutie += deplasare + malStang + malDrept
                f.write(solutie)    



class Graf:
    def __init__(self, start, scopuri):
        self.start = start
        self.scopuri = scopuri

    def scop(self, informatieNod):
        return informatieNod in self.scopuri

    def succesori(self, nod):
        def test(m, c):
            return m == 0 or m >= c

        l = []
        if nod.info[2] == 1: # mal initial = mal curent (cu barca)
            misMalCurent = nod.info[0]
            canMalCurent = nod.info[1]
            misMalOpus = Graf.N - nod.info[0]
            canMalOpus = Graf.N - nod.info[1]
        else:
            misMalCurent = Graf.N - nod.info[0]
            canMalCurent = Graf.N - nod.info[1]
            misMalOpus = nod.info[0]
            canMalOpus = nod.info[1]

        maxMisionariBarca = min(Graf.M, misMalCurent)
 
        for misBarca in range(maxMisionariBarca + 1):
            if misBarca == 0:
                minCanBarca = 1
                maxCanBarca = min(Graf.M, canMalCurent)
            else:
                minCanBarca = 0
                maxCanBarca = min(misBarca, Graf.M - misBarca, canMalCurent)
            
            misMalCurentNou = misMalCurent - misBarca
            misMalOpusNou = misMalOpus + misBarca

            for canBarca in range(minCanBarca, maxCanBarca + 1):
                canMalCurentNou = canMalCurent - canBarca
                canMalOpusNou = canMalOpus + canBarca

                if not test(misMalCurentNou, canMalCurentNou) or not test(misMalOpusNou, canMalOpusNou):
                    continue
                
                if nod.info[2] == 1:
                    infoNou = (misMalCurentNou, canMalCurentNou, 0)
                else:
                    infoNou = (misMalOpusNou, canMalOpusNou, 1)
                
                nodNou = NodArbore(infoNou, nod)
                if not nodNou.vizitat():
                    l.append(nodNou)
        return l



def BreadthFirst(graf, nrSolutii):
    coada = [NodArbore(graf.start)]
    while coada:
        nodCurent = coada.pop(0)
        if graf.scop(nodCurent.info):
            print(repr(nodCurent)) # ex 1
            nodCurent.afisSolFisier("output.txt") # ex 3 (tema)
            nrSolutii -= 1
            if nrSolutii == 0:
                return
        listaSuccesori = graf.succesori(nodCurent)
        coada.extend(listaSuccesori)


# N canibali, N misionari, M locuri in barca

f = open ("input.txt", "r")
continut = f.read().strip().split()
Graf.N = int(continut[0])
Graf.M = int(continut[1])

start = (Graf.N, Graf.N, 1)
scopuri = [(0, 0, 0)]
graf = Graf(start, scopuri)
BreadthFirst(graf, 1)
