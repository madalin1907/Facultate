def back(k):
    global suma
    if suma == n:
        print(*x[:k])
    else:
        for i in range(1, t+1 if k == 0 else x[k-1]+1):
            x[k] = i
            suma += i
            if suma <= n:
                back(k+1)
            suma -= i

n = int(input("n = "))
t = int(input("t = "))

suma = 0
x = [0 for i in range(n+1)]
back(0)
