# #ex1
# def nrcif(x):
#     k = 1
#     while x > 9:
#         k += 1
#         x //= 10
#     return k
#
#
n = int(input("n="))
lista = [int(i) for i in input("numere:").split()]
# lista.sort(key=nrcif)
# print(lista)


# #ex2
# def nrcifpare(x):
#     if x == 0:
#         k = 1
#     else:
#         k = 0
#         while x != 0:
#             if x % 2 == 0:
#                 k += 1
#             x //= 10
#     return k
#
#
# n = int(input("n="))
# lista = [int(i) for i in input("numere:").split()]
# lista.sort(key=nrcifpare, reverse=True)
# print(lista)


# #ex3
# n = int(input("n="))
# lista = []
# for i in range(n):
#     lista.append(int(input("element:")))
# lista.sort(key=lambda x: x % 10)
# print(lista)

# #ex4
# def sort_cod_nume(x):
#     return x[0], x[1]
#
#
# def sort_nrore_nume(x):
#     return x[2], x[1]
#
#
# n = int(input("n="))
# lista = []
# for i in range(n):
#     lista.append(tuple(input("disciplina: ").split()))
#
# b = sorted(lista, key=sort_cod_nume)
# print(b)
#
# c = sorted(lista, key=sort_nrore_nume, reverse=True)
# print(c)


# #ex5
# tuplu1 = tuple(input("Primul tuplu:").split())
# tuplu2 = tuple(int(input("Al doilea tuplu:").split()))
# print(tuplu1, tuplu2)
# tuplu1, tuplu2 = tuplu2, tuplu1
# print(tuplu1, tuplu2)


# #ex6
# n = int(input("n="))
# lista = []
# for i in range(n):
#     lista.append(tuple(input("tuplu: ").split()))
# tuplu = tuple(lista)
#
# tuplu1 = sorted(tuplu, key=lambda x: x[0])
# print(tuplu1)
# tuplu2 = sorted(tuplu, key=lambda x: x[1])
# print(tuplu2)
