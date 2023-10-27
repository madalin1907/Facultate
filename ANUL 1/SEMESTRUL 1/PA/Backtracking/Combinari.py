"""
COMBINARI (n,m) - ale multimii {1,2,..n}   =   submultimi cu m elemente (distincte):
n=4, m=3
1 2 3
1 2 4
1 3 4
2 3 4

Fiecare pozitie xk poate lua valori de la 1 la n
Conditii de continuare la pasul k (valid(k)): xk > xk-1 (paentru k>0) - crescator
Conditii finale: nu este necesar niciun test suplimentar, conditiile de continuare sunt suficiente

Se modifica programul de aranjamanete punand conditia x[k]>x[k-1] - crescator
"""

def back(k):
    if k == m:
        print(*x)
    else:
        """
        for i in range(1, n+1):
            x[k] = i
            if (k == 0) or (x[k] > x[k-1]):
                back(k+1)
        """
        #putem da valori lui x[k] incepand cu x[k-1]+1
        if k == 0:
            start = 1
        else:
            start = x[k-1]+1
        for i in range(start, n + 1):
            x[k] = i
            back(k + 1)


n = int(input("n = "))
m = int(input("m = "))
x = [0 for i in range(m)]
back(0)

