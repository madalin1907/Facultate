#a
def divizori(*args):
    dic = {}
    for x in args:
        dic[x] = []
        y = x
        d = 2
        while y > 1:
            if y % d == 0:
                while y % d == 0:
                    y //= d
                dic[x].append(d)
            d += 1
    return dic

print(divizori(11, 15, 27, 100))


# #b
# litere_10 = [x for x in "abcdefghij"]
# print(litere_10)

litere_10 = [i for i in range(1, 27) if (i % 2 == 0 or i % 3 == 0) and i % 6 != 0]
print(litere_10)
