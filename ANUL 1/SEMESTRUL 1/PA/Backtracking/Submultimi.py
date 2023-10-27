'''
Problema se reduce la a genera toate sirurile binare de lungime n folosind backtracking:
solutia x=(x0,...,x_{n-1})
valori pt xk -> 0 sau 1
Conditii finale - nimic
Conditii de continuare - nimic
'''

def back(k):
    if k == n:
        print(*[a[i] for i in range(n) if x[i] == 1])
    else:
        for i in range(0, 2):
            x[k] = i
            back(k+1)

a = [int(x) for x in input("Lista: ").split()]
n = len(a)
x = [0 for i in range(n)]
back(0)
