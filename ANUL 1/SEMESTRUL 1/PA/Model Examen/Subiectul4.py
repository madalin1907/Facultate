def back(k):
    if k == n:
        print(*x)
    else:
        for i in range(1, n+1):
            x[k] = i
            if x[k] not in x[:k]:
                back(k+1)

n = int(input("n = "))
x = [0 for i in range(n)]
back(0)
