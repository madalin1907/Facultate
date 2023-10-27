'''
Nume: Florea
Prenume: Mădălin-Alexandru
Grupa: 143

Enunț:
Fișierul text text.in conține pe prima linie un cuvânt w nevid format din litere mici ale
alfabetului englez, iar pe următoarele linii un text în care cuvintele sunt despărțite prin spații
și semnele de punctuație uzuale. Să se scrie în fișierul text 𝑡𝑒𝑥𝑡. 𝑜𝑢𝑡 toate cuvintele din fișierul
𝑡𝑒𝑥𝑡. 𝑖𝑛 care au un prefix comun nevid cu 𝑤 sau mesajul "𝐼𝑚𝑝𝑜𝑠𝑖𝑏𝑖𝑙" dacă în fișierul de
intrare nu există nici un cuvânt cu proprietatea cerută. Cuvintele vor fi scrise în ordinea
descrescătoare a lungimilor prefixelor maximale pe care le au cu cuvântul w, iar în cazul unor
lungimi egale vor fi ordonate alfabetic. Fiecare cuvânt va fi scris o singură dată și nu se va face
distincție între litere mici și litere mari.
'''

f = open("text.in", "r")
g = open("text.out", "w")
w = f.readline().rstrip()
lw = len(w)
cuvinte = []

prop = f.read().split()
for i in range(len(prop)):
    if not prop[i][-1].isalpha():
        prop[i] = prop[i][:-1]
prefixe = {}

def ordonare(x):
    return -prefixe[x], x

for i in range(lw, 0, -1):
    for cuvant in prop:
        if cuvant[:i] == w[:i]:
            cuvinte.append(cuvant.strip())
            if cuvant not in prefixe:
                prefixe[cuvant] = i

multime = list(set(cuvinte))
multime.sort(key=ordonare)
for cuvant in multime:
    g.write(cuvant+"\n")

if len(cuvinte) == 0:
   g.write("Imposibil")

f.close()
g.close()
