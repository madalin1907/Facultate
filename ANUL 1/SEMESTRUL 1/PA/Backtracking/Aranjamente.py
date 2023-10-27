"""
ARANJAMENTE(n,m) - ale multimii {1,2,..n}      ->      1,2,3 != 1,3,2

Fiecare pozitie xk poate lua valori de la 1 la n
Conditii de continuare la pasul k (valid(k)): xk sa fie diferit de x0...xk-1
Conditii finale: nu este necesar niciun test suplimentar, conditiile de continuare sunt suficiente

Se modifica programul de permutari inlocuind doar lungimea lui x
"""

def back(k):
    if k == m:
        print(*x)
    else:
        for i in range(1, n+1):
            x[k] = i
            if i not in x[:k]:
                back(k+1)

n = int(input("n = "))
m = int(input("m = "))
x = [0 for i in range(m)]
back(0)


def back2(k):
    if k == m:
        print([elevi[x[i]-1] for i in range(m)])
    else:
        for i in range(1, n + 1):
            x[k] = i
            if x[k] not in x[:k]:
                back2(k + 1)

n = 4
m = 2
elevi = ["Ion", "Ioana", "Mihai", "Mihaela"]
x = [0 for i in range(m)]
v = [0 for i in range(n+1)]
back2(0)