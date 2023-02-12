# #a
# def aparitii(*numere):
#     dictionar = {}
#     for x in numere:
#         frecv = []
#         numar = set(str(x))
#         for cifra in numar:
#             frecv.append((int(cifra), str(x).count(cifra)))
#         dictionar[x] = frecv
#     return dictionar
#
# print(aparitii(1011, 234, 8158558))



#b
m = [[1, 2, 3, 5], [4, 5, 6, 10], [4, 7, 8, 9], [6, 6, 6, 6]]
numere = [m[i][i]**2 for i in range(len(m))]
print(numere)