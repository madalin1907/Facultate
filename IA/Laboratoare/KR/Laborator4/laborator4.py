import copy

class NodArbore:
    def __init__(self, info, parinte = None, g = 0, h = 0):
        self.info = info
        self.parinte = parinte
        self.g = g
        self.h = h
        self.f = g + h

    def drumRadacina(self) :
        l = []
        nod = self
        while nod is not None:
            l.insert(0, nod)
            nod = nod.parinte
        return l

    def vizitat(self) :
        nod = self.parinte
        while nod is not None:
            if nod.info == self.info:
                return True
            nod = nod.parinte
        return False

    def __str__(self):
        return "{} ({}, {})".format(self.info, self.g, self.f)

    def __repr__(self):
        return "({}, ({}), cost:{})".format(self.info, "->".join([str(x) for x in self.drumRadacina()]), self.f)


class Graf:
    def __init__(self, start, scopuri):
        self.start = start
        self.scopuri = scopuri
        if not self.valideaza():
            print("Date de intrare invalide")
            exit(0)

    def scop(self, infoNod):
        return infoNod in self.scopuri

    def succesori(self, nod):
        l = []
        for istiva, stiva in enumerate(nod.info):
            if not stiva:
                continue
            copieStive = copy.deepcopy(nod.info)
            bloc = copieStive[istiva].pop()
            for istiva2 in range(len(copieStive)):
                if istiva == istiva2:
                    continue
                stiveNoi = copy.deepcopy(copieStive)
                stiveNoi[istiva2].append(bloc)
                nodNou = NodArbore(stiveNoi, nod, nod.g + 1)
                if not nodNou.vizitat():
                    nodNou.h = self.estimeaza_h(nodNou, "euristica costuri")
                    l.append(nodNou)
        return l


    # TEMA (ex. 3)
    def estimeaza_h(self, nod, euristica = "euristica banala"):
        # verificam daca nodul curent este in starea scop (caz in care euristica va fi 0)
        if euristica.lower() == "euristica banala":
            if self.scop(nod.info):
                return 0
            return 1

        # verificam cate blocuri din starea curenta nu sunt pe pozitia lor din starile scop si pastram minimul
        elif euristica.lower() == "euristica mutari":
            minim = float('inf')
            for scop in self.scopuri:
                nrBlocuri = 0
                for stivaCurenta, stivaScop in zip(nod.info, scop):
                    nrBlocuri += sum([1 for bloc in stivaCurenta if bloc not in stivaScop])
                minim = min(minim, nrBlocuri)
            return minim

        # verificam care noduri nu sunt pe pozitia lor din starile scop si calculam suma costurilor de mutare pentru fiecare, pastrand minimul 
        elif euristica.lower() == "euristica costuri":
            minim = float('inf')
            for scop in self.scopuri:
                costMutare = 0
                for stivaCurenta, stivaScop in zip(nod.info, scop):
                    for bloc in stivaCurenta:
                        if bloc not in stivaScop:
                            costMutare+= (ord(bloc) - ord('A') + 1)
                minim = min(minim, costMutare)
            return minim

        # daca euristica e neadmisibila, returnam si noi tot o valoare neadmisibila (infinit)
        elif euristica.lower() == "euristica neadmisibila":
            return float('inf')


    def valideaza(self):
        cond1 = all([len(self.start) == len(scop) for scop in self.scopuri])
        listaBlocuri = sorted(sum(self.start, start = []))
        cond2 = all([listaBlocuri == sorted(sum(scop, start = [])) for scop in self.scopuri])
        return cond1 and cond2


def bin_search(listaNoduri, nodNou, ls, ld):
    if len(listaNoduri) == 0:
        return 0
    if ls == ld:
        if nodNou.f < listaNoduri[ls].f:
            return ls
        elif nodNou.f > listaNoduri[ls].f:
            return ld + 1
        else: # f-uri egale
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

def aStarSolMultiple(gr, nrSolutiiCautate=1):
    # in coada vom avea doar noduri de tip NodParcurgere (nodurile din arborele de parcurgere)
    c = [NodArbore(gr.start)]

    while len(c) > 0:
        #print("Coada actuala: " + str(c))
        #input()
        nodCurent = c.pop(0)

        if gr.scop(nodCurent.info):
            print("Solutie:")
            drum = nodCurent.drumRadacina()
            print(("->").join([str(n.info) for n in drum]))
            print("cost:", nodCurent.g)
            print("\n----------------\n")
            #input()
            nrSolutiiCautate -= 1
            if nrSolutiiCautate == 0:
                return
        #[2,4,7,8,10,14]
        # c+=gr.succesori(nodCurent)
        for s in gr.succesori(nodCurent):
            indice = bin_search(c, s, 0, len(c) - 1)
            if indice == len(c):
                c.append(s)
            else:
                c.insert(indice, s)



def a_star(gr):
    # in coada vom avea doar noduri de tip NodParcurgere (nodurile din arborele de parcurgere)
    l_open = [NodArbore(gr.start)]

    # l_open contine nodurile candidate pentru expandare (este echivalentul lui c din A* varianta neoptimizata)

    # l_closed contine nodurile expandate
    l_closed = []
    while len(l_open) > 0:
        # print("Coada actuala: " + str(l_open))
        # input()
        nodCurent = l_open.pop(0)
        l_closed.append(nodCurent)
        if gr.scop(nodCurent.info):
            print("Solutie:")
            drum = nodCurent.drumRadacina()
            print(("->").join([str(n.info) for n in drum]))
            print("cost:", nodCurent.g)
            return
        lSuccesori = gr.succesori(nodCurent)
        for s in lSuccesori:
            gasitC = False
            for nodC in l_open:
                if s.info == nodC.info:
                    gasitC = True
                    if s.f >= nodC.f:
                        lSuccesori.remove(s)
                    else:  # s.f<nodC.f
                        l_open.remove(nodC)
                    break
            if not gasitC:
                for nodC in l_closed:
                    if s.info == nodC.info:
                        if s.f >= nodC.f:
                            lSuccesori.remove(s)
                        else:  # s.f<nodC.f
                            l_closed.remove(nodC)
                        break
        for s in gr.succesori(nodCurent):
            indice=bin_search(l_open, s, 0, len(l_open)-1)
            if indice==len(l_open):
                l_open.append(s)
            else:
                l_open.insert(indice, s)


def calculeazaStive(sirStiva):
    listaSiruriStive=sirStiva.strip().split('\n')
    return [sir.strip().split() if sir!='#' else [] for sir in listaSiruriStive]




f = open('input.txt',"r")
continut = f.read()
[sirStart, sirScopuri] = continut.strip().split("=========")
start = calculeazaStive(sirStart)
siruriScopuri = sirScopuri.strip().split("---")
scopuri = [calculeazaStive(sir) for sir in siruriScopuri]
gr = Graf(start, scopuri)
a_star(gr)