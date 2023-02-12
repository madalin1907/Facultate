def back(k):
    if k == 6:
        paritati = [i % 2 for i in x]
        if min(paritati) != max(paritati):
            print(*x)
    else:
        for i in range(1, n+1):
        #b    if i == 13:
        #b        continue
            x[k] = i
            if k == 0 or x[k] - x[k-1] >= 2:
                back(k+1)


n = int(input("n = "))
x = [0 for i in range(6)]
back(0)