"""
Toate modalitatile de a scrie n ca suma de numere naturale nenule
n=4:
1+1+1+1
1+1+2 = 1+2+1
1+3
2+2
4

x=x0,x1,..xk (lungime variabila)  reprezentand termeni din descompunere
xk poate lua valorile: 1,2,..,n
Cond de continuare:  x0+...xk<=n si xk>=x_{k-1}
Conditii finale: nu este necesar niciun test suplimentar, conditiile de continuare sunt suficiente
"""

#Varianta1 - cu suma calculata de fiecare data"
def back(k):
    if sum(x[:k]) == n:
        print(*x[:k])
    else:
        if k == 0:
            start = 1
        else:
            start = x[k-1]
        for i in range(start, n+1):
            x[k] = i
            if sum(x[:k+1]) <= n:
                back(k+1)

n = int(input("suma = "))
x = [0 for i in range(n)]
back(0)

#Varianta2 - nu calculam suma de fiecare data, ci actualizam suma curenta in functie de valoarea lui x[k]
def back2(k):
    global suma
    if suma == n:
        print(*x[:k])
    else:
        if k == 0:
            start = 1
        else:
            start = x[k-1]
        for i in range(start, n+1):
            x[k] = i
            suma += x[k]
            if suma <= n:
                back2(k+1)
            suma -= x[k]

n = int(input("suma = "))
suma = 0
x = [0 for i in range(n)]
back2(0)
