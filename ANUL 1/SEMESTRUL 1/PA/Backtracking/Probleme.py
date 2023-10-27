# #1 - Anagramele unui cuvant
# def back(k):
#     if k == n:
#         for i in x:
#             print(s[i], end="")
#         print()
#     else:
#         for i in range(0, n):
#             x[k] = i
#             if x[k] not in x[:k]:
#                 back(k+1)
#
# s = input("cuvant:")
# n = len(s)
# x = [0 for i in range(n)]
# back(0)


# #2 - Submulțimile de sumă M ale unei mulțimi date
# def back(k):
#     global suma
#     if suma == M:
#         print('{', end="")
#         print(*[v[i] for i in x[:k]], sep=", ", end="")
#         print('}')
#     else:
#         if k == 0:
#             start = 0
#         else:
#             start = x[k - 1] + 1
#         for i in range(start, n):
#             x[k] = i
#             suma += v[i]
#             if suma <= M:
#                 back(k+1)
#             suma -= v[i]
#
#
# v = [int(x) for x in input("Multimea: ").split()]
# n = len(v)
# M = int(input("Suma: "))
#
# suma = 0
# x = [0 for i in range(n)]
# back(0)


# #3 - Modalități de a forma grupe de elevi cu cel puțin o fată și cel puțin un băiat
# def back(a):
#     if a == k:
#         if min(x) <= n < max(x):
#             print(*x)
#     else:
#         if a == 0:
#             start = 1
#         else:
#             start = x[a-1]+1
#         for i in range(start, n+m+1):
#             x[a] = i
#             back(a + 1)
#
#
# n = int(input("n = "))
# m = int(input("m = "))
# k = int(input("k = "))
# x = [0 for i in range(k)]
# back(0)


# #5 - Să se afișeze toate numerele naturale cu n cifre având suma cifrelor s
# def back(k):
#     if k == n:
#         if sum(x[:k]) == s:
#             print(*x[:k], sep="")
#     else:
#         if k == 0:
#             start = 1
#         else:
#             start = 0
#         for i in range(start, 10):
#             x[k] = i
#             back(k+1)
#
#
# n = int(input("n = "))
# s = int(input("s = "))
# x = [0 for i in range(n)]
# back(0)
