def back(k):
    global suma, elem
    if suma == p:
        #pt b: if len(set(x[:k])) == 2:
            print(*[v[a] for a in x[:k]])
    else:
        if k == 0:
            start = 0
        else:
            start = x[k - 1]
        for i in range(start, len(v)):
            x[k] = i
            suma += v[i]
            if suma <= p:
                back(k + 1)
            suma -= v[i]


p = int(input("p = "))
suma = 0
v = [d for d in range(1, p) if p % d == 0]
x = [0 for i in range(p)]
suma = 0
back(0)
