#1
#a
def back(k):
    global suma
    if k == n:
        if suma == S:
            print(*x, sep=", ")
    else:
        for i in range(v[k] + 1):
            x[k] = i
            suma += i * monede[k]
            if suma <= S:
                back(k+1)
            suma -= i * monede[k]

S = int(input("Suma este: "))
monede = [int(x) for x in input("Monedele sunt: ").split()]
n = len(monede)

suma = 0
v = [S // x for x in monede]
x = [0 for i in range(n)]
back(0)



# #b
# def back(k):
#     global suma, nr
#     if k == n:
#         if suma == S:
#             print(*x, sep=", ")
#     else:
#         for i in range(v[k] + 1):
#             x[k] = i
#             suma += i * monede[k]
#             nr += i
#             if suma <= S and nr <= M:
#                 back(k+1)
#             suma -= i * monede[k]
#             nr -= i
#
#
# f = open("1b.in", "r")
# S = int(f.readline())
# monede = [int(x) for x in f.readline().split()]
# n = len(monede)
# v = [int(x) for x in f.readline().split()]
# M = int(f.readline())
#
# x = [0 for i in range(n)]
# suma = 0
# nr = 0
# back(0)



# #2 Produs cartezian
# def back(k):
#     if k == n:
#         for i in range(n):
#             print(multimi[i][x[i]], end=" ")
#         print()
#     else:
#         for i in range(card[k]):
#             x[k] = i
#             back(k+1)
#
#
# f = open("date2.in", "r")
# multimi = [[int(x) for x in linie.split()] for linie in f.readlines()]
# f.close()
# card = [len(x) for x in multimi]
# n = len(multimi)
#
# x = [0 for i in range(n)]
# back(0)



# #3 Chestionar de intrebari
# def back(k):
#     global suma
#     if k == a:
#         if suma == p:
#             print(*x)
#     else:
#         if k == 0:
#             start = 1
#         else:
#             start = x[k-1] + 1
#         for i in range(start, n+1):
#             x[k] = i
#             suma += pct[i-1]
#             if suma <= p:
#                 back(k+1)
#             suma -= pct[i-1]
#
#
# n = int(input("Total intrebari: "))
# pct = [int(x) for x in input("Punctaje intrebari: ").split()]
# a = int(input("Lungime chestionar: "))
# p = int(input("Punctaj total chestionar: "))
#
# suma = 0
# x = [0 for i in range(a)]
# back(0)



# #4 n scris ca suma de nr prime
# def back(k):
#     global suma
#     if suma == n:
#         print(*[nrprime[a] for a in x[:k]], sep = " + ")
#     else:
#         if k == 0:
#             start = 0
#         else:
#             start = x[k - 1]
#
#         for i in range(start, m):
#             x[k] = i
#             suma += nrprime[i]
#             if suma <= n:
#                 back(k+1)
#             suma -= nrprime[i]
#
#
# def prim(x):
#     if x == 2:
#         return True
#     if x % 2 == 0:
#         return False
#     i = 3
#     while i*i <= x:
#         if x % i == 0:
#             return False
#         i += 2
#     return True
#
#
# n = int(input("n = "))
# nrprime = [x for x in range(2, n+1) if prim(x)]
# m = len(nrprime)
#
# suma = 0
# x = [0 for i in range(n//2+1)]
# back(0)
