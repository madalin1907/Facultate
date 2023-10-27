# #ex1
# n = int(input("n="))
# lista = [int(i) for i in input("lista: ").split()]
# x = int(input("x= "))
# if x not in lista:
#     print(f"Elementul {x} nu se afla in lista.")
# else:
#     while x in lista:
#         lista.remove(x)
#     print(lista)


# #ex2
# lista = [1, 2, [3, [4, 5, [6, 7], 11], 12], 13, 14]
# sublista = [8, 9, 10]
# lista[2][1][2].extend(sublista)
# print(lista)

# #ex3
# #a
# a = [i for i in range(2, 25) if i % 2 == 0]
# print(a)
#
# #b
# n=int(input("n = "))
# b = [-i if i % 2 == 1 else i for i in range(1, n+1)]
# print(b)

# #c
# list1 = [i for i in input("lista: ").split()]
# c = [list1[i] for i in range(len(list1)) if i % 2 == 0]
# print(c)

# #d
# l1 = [int(x) for x in input("lista: ").split()]
# d = [l1[i] for i in range(len(l1)) if l1[i] % 2 == i % 2]
# print(d)

# #e
# n = int(input("n = "))
# e = [[i]*i for i in range(n)]
# print(e)


# #ex4
# n = int(input("n="))
# lista = [int(i) for i in input("lista: ").split()]
# pare = []
# impare = []
# for i in lista:
#     aux = i
#     sumcif = 0
#     while aux != 0:
#         sumcif += aux % 10
#         aux //= 10
#     if sumcif % 2 == 0:
#         pare.append(i)
#     else:
#         impare.append(i)
#
# pare.sort(reverse = True)
# impare.sort()
# lista = pare + impare
# print(lista)


# #ex5
# #a
# m = int(input("m = "))
# n = int(input("n = "))
# x = int(input("x = "))
#
# matrice = [[0 for j in range(n)] for i in range(m)]
# element = 0
#
# for i in range(m):
#     for j in range(n):
#         if i % 2 == 0:
#             matrice[i][j] = (i * n +j) * x
#         else:
#             matrice[i][j] = (i * n + n - j - 1) * x
#
# for i in matrice:
#     for j in i:
#         print(f"{j}".rjust(3), end=" ")
#     print()

# #b
# m = int(input("m = "))
# n = int(input("n = "))
# matrice = []
# for i in range(m):
#     linie = [int(i) for i in input().split()]
#     matrice.append(linie)
# summax = -1
# indice = -1
# for j in range(n):
#     suma = 0
#     for i in range(m):
#         suma += matrice[i][j]
#     if suma > summax:
#         summax = suma
#         indice = j

# #c
# n = int(input("n = "))
# matrice = []
# for i in range(n):
#     linie = [int(j) for j in input().split()]
#     matrice.append(linie)
#
# suma_diag_princ = 0
# for i in range(n):
#     suma_diag_princ += matrice[i][i]
# print(f"Suma elementelor de pe diagonala principala este {suma_diag_princ}.")
#
# produs_diag_sec = 1
# for i in range(n):
#     produs_diag_sec *= matrice[i][n-1-i]
# print(f"Produsul elementelor de pe diagonala secundara este {produs_diag_sec}.")
#
# suma = 0
# for i in range(n):
#     for j in range(n):
#         if matrice[i][j] % 2 == 1 and i > j and i + j < n - 1:
#             suma += matrice[i][j]
# print(f"Suma elementelor impare aflate sub diagonala principala si deasupra celei secundare este {suma}.")
