# #ex1
# s1 = input("s1: ")
# s2 = input("s2: ")
# s2 = s2[::-1]
# s3 = ""
#
# l1 = len(s1)
# l2 = len(s2)
#
# lungime = min(l1, l2)
# for i in range(lungime):
#     s3 = s3 + s1[i]
#     s3 = s3 + s2[i]
#
# if l1 != l2:
#     if l1 > l2:
#         s3 = s3 + s1[l2:]
#     else:
#         s3 = s3 + s2[l1:]
# print(s3)

# #SAU

# #ex1
# s1 = input("s1=")
# s2 = input("s2=")
# s2 = s2[::-1]
# s3 = ""
# l1 = len(s1)
# l2 = len(s2)
# lungime = max(l1, l2)
#
# for i in range(lungime):
#     if i < l1:
#         s3 = s3 + s1[i]
#     if i < l2:
#         s3 = s3 + s2[i]
# print(s3)

# #ex2
# s1 = input("s1: ")
# s2 = input("s2: ")
# n = s1.lower().count(s2.lower())
# print(f"Sirul s2 apare de {n} ori in sirul s1.")

# #ex3
# s = input("s: ")
# suma = 0
# produs = 1
# nrcifre = 0
# for i in range(len(s)):
#     if s[i].isdigit():
#         nrcifre += 1
#         suma += int(s[i])
#         produs *= int(s[i])
# print(f"Suma cifrelor din sirul s este {suma}")
# print(f"Produsul cifrelor din sirul s este {produs}")
# print(f"Media aritmetica a cifrelor din sirul s este {suma/nrcifre}")


# #ex4
# import string
# semne = string.punctuation
# s1 = input("s1: ")
# for caracter in s1:
#     if caracter in semne:
#         s1 = s1.replace(caracter, "*")
# print(s1)


# #ex5
# sir = input("sir: ")
# s = input("s: ")
# mijloc = len(sir) // 2
# sir = sir[:mijloc] + s + sir[mijloc:]
# print(sir)


# #ex6
# sir = input("sir: ")
# s = ""
# for i in range(len(sir)):
#     if sir[i].isalpha() and sir[i].isupper():
#         s = s + sir[i].lower()
#     else:
#         s = s + sir[i]
# print(s)


# #ex7
# sir = input("sir: ")
# s = ""
# for i in range(0, len(sir), 2):
#     s = s + sir[i]
# print(s)


# #ex8
# x=3.1415926
# y=14.9999
# print(f"{x:.2f}, {y:.2f}")


# #ex9
# sir = input("sir: ")
#
# for i in sir:
#     if (not i.isalpha()) and (i not in " -"):
#         print("Sirul nu este un nume corect.")
#         exit()
#
# if sir.count(" ") != 1 or sir.count("-") > 1:
#     print("Sirul nu este un nume corect.")
#     exit()
#
# lista = sir.split()
#
# nume = lista[0]
# if nume[0].islower() or len(nume) < 3 or '-' in nume:
#         print("Sirul nu este un nume corect.")
#         exit()
#
# prenume = lista[1]
# if prenume[0] == '-' or prenume[-1] == '-':
#     print("Sirul nu este un nume corect.")
#     exit()
#
# lista_prenume = prenume.split(sep='-')
# for x in lista_prenume:
#     if x[0].islower() or len(x) < 3:
#         print("Sirul nu este un nume corect.")
#         exit()
#
# print("Sirul este un nume corect.")


# #ex10
# s1 = input("s1: ")
# s2 = input("s2: ")
# if s1[-1] == s2[0]:
#     print(s1+s2[1:])
# elif s1[1] == s2[-2]:
#     print(s1+s2)
