#a
f = open ("spiridusi.in", "r")
dict = {}
for linie in f.readlines():
    rand = linie.split()
    if rand[0] not in dict:
        dict[rand[0]] = {}
    if rand[2] not in dict[rand[0]]:
        dict[rand[0]][rand[2]] = int(rand[1])
    else:
        dict[rand[0]][rand[2]] += int(rand[1])
print(dict)

#b
def despre_spiridus(dictionar, cod):
    info = [(juc, dictionar[cod][juc]) for juc in dictionar[cod]]
    info.sort(key = lambda x: (-x[1], x[0]))
    return info

S1 = despre_spiridus(dict, 'S1')
print(S1)

#c
def jucarii(dict):
    toys = []
    for spiridus in dict:
        lista = despre_spiridus(dict, spiridus)
        for juc in lista:
            if juc[0] not in toys:
                toys.append(juc[0])
    return toys
print(*jucarii(dict))

#d
def spiridusi(dict):
    lista = []
    for spiridus in dict:
        tipjucarii = len(dict[spiridus])
        nrjucarii = 0
        for jucarie in dict[spiridus]:
            nrjucarii += dict[spiridus][jucarie]
        lista.append((spiridus, tipjucarii, nrjucarii))

    lista.sort(key=lambda x: (-x[1], -x[2], x[0]))
    return lista

lista = spiridusi(dict)
print(lista)

#e
def actualizare(dict, cod, nume):
    if len(dict[cod]) >= 2:
        if nume in dict[cod]:
            dict[cod].pop(nume)
            return True
    return False

actualizare(dict, 'S1', 'trenulet')
print(despre_spiridus(dict, "S1"))




tuplu = (1,3)
tuplu = tuplu[::-1]
print(tuplu)