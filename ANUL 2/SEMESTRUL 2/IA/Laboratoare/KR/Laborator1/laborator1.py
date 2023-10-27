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



class Graf:
    def __init__(self, matr, start, scopuri):
        self.matr = matr
        self.start = start
        self.scopuri = scopuri

    def scop(self, informatieNod):
        return informatieNod in self.scopuri

    def succesori(self, nodCurent):
        listaSuccesori = []
        for i in range(len(self.matr)):
            if self.matr[nodCurent.info][i] == 1:
                nodNou = NodArbore(i, nodCurent)
                if not nodNou.vizitat():
                    listaSuccesori.append(nodNou)
        return listaSuccesori



# 2.
def BreadthFirst(graf, nrSolutii):
    coada = [NodArbore(graf.start)]
    while coada:
        nodCurent = coada.pop(0)
        if graf.scop(nodCurent.info):
            print(repr(nodCurent))
            nrSolutii -= 1
            if nrSolutii == 0:
                return
        listaSuccesori = graf.succesori(nodCurent)
        coada.extend(listaSuccesori)



# 3.
def DepthFirst(graf, nodCurent):
    global nrSolutii
    for vecin in graf.succesori(nodCurent):
        if not vecin.vizitat():
            if vecin.info in graf.scopuri:
                print(repr(vecin))
                nrSolutii -= 1
                if nrSolutii == 0:
                    return
            # else:
            DepthFirst(graf, vecin)
            if nrSolutii == 0:
                return



matrice = [
    [0, 1, 0, 1, 1, 0, 0, 0, 0, 0],
    [1, 0, 1, 0, 0, 1, 0, 0, 0, 0],
    [0, 1, 0, 0, 0, 1, 0, 1, 0, 0],
    [1, 0, 0, 0, 0, 0, 1, 0, 0, 0],
    [1, 0, 0, 0, 0, 0, 0, 1, 0, 0],
    [0, 1, 1, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 1, 0, 0, 0, 0, 0, 0],
    [0, 0, 1, 0, 1, 0, 0, 0, 1, 1],
    [0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 1, 0, 0]
]

start = 0
scopuri = [5, 9]
graf = Graf(matrice, start, scopuri)

nrSolutii = int(input("nrSolutii = "))

BreadthFirst(graf, nrSolutii)
print("\n-----------------------------\n")
DepthFirst(graf, NodArbore(graf.start))
