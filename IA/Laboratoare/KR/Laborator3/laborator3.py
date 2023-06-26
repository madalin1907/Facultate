class NodArbore:
    def __init__(self, info, parinte = None, g = 0, h = 0):
        self.info = info
        self.parinte = parinte
        self.g = g
        self.h = h
        self.f = g + h

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

    def __str__(self):
        return str(self.info)

    def __repr__(self):
        return "({}, ({}), cost: {})".format(self.info, "->".join([str(x) for x in self.drumRadacina()]), self.f)

    def __lt__(self, other):
        return self.f < other.f

class Graf:
    def __init__(self, matr, start, scopuri, h):
        self.matr = matr
        self.start = start
        self.scopuri = scopuri
        self.estimari = h

    def scop(self, infoNod):
        return infoNod in self.scopuri

    def succesori(self, nod):
        l = []
        for i in range(len(self.matr)):
            if self.matr[nod.info][i] != 0:
                nodNou = NodArbore(i, nod, nod.g + self.matr[nod.info][i], self.calculeaza_h(i))
                if not nodNou.vizitat():
                    l.append(nodNou)
        return l

    def calculeaza_h(self, infonod):
        return self.estimari[infonod]


def bin_search(listaNoduri, nodNou, ls, ld):
    if len(listaNoduri) == 0:
        return 0
    if ls == ld:
        if nodNou.f < listaNoduri[ls].f:
            return ls
        elif nodNou.f > listaNoduri[ls].f:
            return ld + 1
        else:  # f-uri egale
            if nodNou.g < listaNoduri[ls].g:
                return ld + 1
            else:
                return ls
    else:
        mij = (ls + ld) // 2
        if nodNou.f < listaNoduri[mij].f:
            return bin_search(listaNoduri, nodNou, ls, mij)
        elif nodNou.f > listaNoduri[mij].f:
            return bin_search(listaNoduri, nodNou, mij + 1, ld)
        else:
            if nodNou.g < listaNoduri[mij].g:
                return bin_search(listaNoduri, nodNou, mij + 1, ld)
            else:
                return bin_search(listaNoduri, nodNou, ls, mij)


def aStarSolMultiple(graf, nrSolutii):
    coada = [NodArbore(graf.start)]
    while coada:
        nodCurent = coada.pop(0)
        if graf.scop(nodCurent.info):
            print(repr(nodCurent))
            nrSolutii -= 1
            if nrSolutii == 0:
                return
        listaSuccesori = graf.succesori(nodCurent)
        for succesor in listaSuccesori:
            indice = bin_search(coada, succesor, 0, len(coada) - 1)
            if indice == len(coada):
                coada.append(succesor)
            else:
                coada.insert(indice, succesor)


from queue import PriorityQueue

def aStarSolUnica(graf):
    open = PriorityQueue()
    open.put(NodArbore(graf.start))
    closed = []
    
    while open:
        nodCurent = open.get() # scoatem primul element din coada
        if graf.scop(nodCurent.info): 
            print(repr(nodCurent))
            return
        
        closed.append(nodCurent)

        listaSuccesori = graf.succesori(nodCurent)
        for succesor in listaSuccesori:
            nodNou = None
            
            if succesor not in nodCurent.drumRadacina():
                if succesor in open.queue:
                    nodOpen = open.get(succesor)
                    if succesor.f < nodOpen.f:
                        succesor.parinte = nodCurent
                        # costul nodului curent plus costul muchiei de la nodul curent la succesor
                        succesor.g = nodCurent.g + graf.matr[nodCurent.info][succesor.info]
                        succesor.f = succesor.g + succesor.h
                        nodNou = succesor

                if succesor in closed:
                    index = bin_search(closed, succesor, 0, len(closed) - 1)
                    nodClosed = closed[index]
                    if succesor.f < nodClosed.f:
                        closed.remove(nodClosed)
                        succesor.parinte = nodCurent
                        # costul nodului curent plus costul muchiei de la nodul curent la succesor
                        succesor.g = nodCurent.g + graf.matr[nodCurent.info][succesor.info]
                        succesor.f = succesor.g + succesor.h
                        nodNou = succesor
                else:
                    nodNou = succesor

                open.put(nodNou)



m = [
    [0, 3, 5, 10, 0, 0, 100],
    [0, 0, 0, 4, 0, 0, 0],
    [0, 0, 0, 4, 9, 3, 0],
    [0, 3, 0, 0, 2, 0, 0],
    [0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 4, 0, 5],
    [0, 0, 3, 0, 0, 0, 0],
]

start = 0
scopuri = [4, 6]
h = [0, 1, 6, 2, 0, 3, 0]
graf = Graf(m, start, scopuri, h)

print("Solutii multiple:")
aStarSolMultiple(graf, 3)

print("\nSolutie unica:")
aStarSolUnica(graf)
