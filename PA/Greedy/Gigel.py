m = int(input())
A = [int(x) for x in input().split()]
n = int(input())
B = [int(x) for x in input().split()]
A.sort()
B.sort()

suma = 0
for i in range(m):
    if A[i] < 0:
        suma += A[i] * B[i]
    else:
        suma += A[i] * B[n-(m-i)]

print(suma)