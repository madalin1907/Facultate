def back(k):
    global suma
    if suma == n:
        print(*x[:k])

    if k == 0:
        start = 1
    else:
        start = x[k-1] + 1
    for i in range(start, n+1):
        x[k] = i
        suma += x[k]
        if suma <= n:
            back(k+1)
        suma -= x[k]


n = int(input("n = "))
suma = 0
x = [0 for i in range(n)]
back(0)
