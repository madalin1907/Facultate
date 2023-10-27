def back(k):
    global suma
    if suma == h:
        for a in x[:k]:
            g.write(str(a+1) + " ")
        g.write("\n")
    else:
        for i in range(0, n):
            if i not in x[:k]:
                x[k] = i
                suma += cuburi[x[k]][0]
                if k == 0:
                    back(k+1)
                else:
                    if cuburi[x[k-1]][0] >= cuburi[x[k]][0] and cuburi[x[k-1 ]][1] != cuburi[x[k]][1]:
                        back(k+1)
                suma -= cuburi[x[k]][0]


f = open("turn.in", "r")
g = open("turn.out", "w")
inp = f.readline().split()
n, h = int(inp[0]), int(inp[1])
cuburi = [[int(x) for x in linie.split()] for linie in f]
suma = 0
x = [0 for i in range(n+1)]
back(0)
f.close()
g.close()
