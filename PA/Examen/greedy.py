n = int(input())
g = float(input())
numere = []
for i in range(n):
    numere.append((i+1, float(input())))
print(numere)
numere.sort(key=lambda x: -x[1])
print(numere)

i = 1
nr = 0
solutii = []
while i < n:
    if abs(numere[i-1][1] - numere[i][1]) <= g:
        nr += 1
        solutii.append(i)
        i += 1
    i += 1

print(nr)
for i in solutii:
    print(numere[i-1][0], numere[i][0], sep = " + ")
