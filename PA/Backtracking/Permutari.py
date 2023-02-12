"""
Fiecare pozitie poate lua valori de la 1 la n
Conditii de continuare la pasul k (valid(k)): xk sa fie diferit de x0...xk-1
Conditii finale: nu este necesar niciun test suplimentar, conditiile de continuare sunt suficiente
"""

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

# #varianta 2 -> cu vector de frecventa
# def back2(k):
#     if k == n:
#         print(*x)
#     else:
#         for i in range(1, n+1):
#             x[k] = i
#             if v[x[k]] == 0:
#                 v[x[k]] = 1
#                 back2(k + 1)
#                 v[x[k]] = 0
#
# n = int(input("n = "))
# x = [0 for i in range(n)]
# v = [0 for i in range(n+1)]
# back2(0)
#
# '''Permutarile care incep cu un numar dat k'''
#
# def back3(k):
#     if k == n:
#         print(*x)
#     else:
#         for i in range(1, n+1):
#             x[k] = i
#             if x[k] not in x[:k]:
#                 back3(k+1)
#
# n = int(input("n = "))
# k = int(input("k = "))
#
# x = [0 for i in range(n)]
# x[0] = k
# back3(1)
