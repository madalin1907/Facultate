# #ex1
# a = int(input("a="))
# b = int(input("b="))
# c = int(input("c="))
#
# if (a+b > c) and (b+c > a) and (a+c > b):
#     print(f"{a}, {b} si {c} pot fi lungimile laturilor unui triunghi.")
# else:
#     print(f"{a}, {b} si {c} nu pot fi lungimile laturilor unui triunghi.")


# #ex2
# x = int(input("x="))
# i = 1
# while i*i*i < x:
#     i += 1
# if i*i*i == x:
#     print(f"{x} este cub perfect ({i}^3).")
# else:
#     print(f"{x} nu este cub perfect.")


# #ex3
# n = int(input("n="))
# if n % 2 == 1:
#     print("Weird.")
# else:
#     if 2 <= n <= 5:
#         print("Not Weird")
#     elif 6 <= n <= 20:
#         print("Weird")
#     elif 20 < n:
#         print("Not Weird")


# #ex4
# a = int(input("a="))
# b = int(input("b="))
#
# for i in range(a, b+1):
#     if i == 1:
#         continue
#     for divizor in range(2, i//2+1):
#         if i % divizor == 0:
#             break;
#     else:
#         print(f"Primul numar prim din intervalul [{a}, {b}] este {i}.")
#         break
# else:
#     print (f"Nu exista niciun numar prim in intervalul [{a}, {b}].")


# #ex5
# a = int(input("a="))
# b = int(input("b="))
# lista = []
# nrdivmax = -1
# for i in range(a, b+1):
#     x = i
#     nrdiv = 0
#     d = 2
#     while x > 1:
#         if x % d == 0:
#             while x % d == 0:
#                 x /= d
#             nrdiv += 1
#
#         if nrdiv > nrdivmax:
#             nrdivmax = nrdiv
#
#         if d == 2:
#             d += 1
#         else:
#             d += 2
#     lista.append((i, nrdiv))
# for numar in lista:
#     if numar[1] == nrdivmax:
#         print(numar[0], " ", end="")


# #ex6
# n = int(input("n="))
# lista = [int(x) for x in input("sirul de numere: ").split()]
# lista.sort()
# if lista[0] == lista[n-1]:
#     print("Nu se poate.")
# else:
#     for i in range(1, n):
#         if lista[i] != lista[0]:
#             print(lista[0], lista[i], sep=" ")
#             break


# #ex7
# from math import sqrt
# x = int(input("x="))
# val_fct = int()
# if x <= -9:
#     val_fct = abs(x)
# elif -9 < x < 0:
#     val_fct = sqrt(x+9)
# elif 0 <= x <= 10:
#     val_fct = x ** 2
# print(f"f({x}) = {val_fct}")
