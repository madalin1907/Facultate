def back(k):
   for a in range(i, j+1):
       if k == a == 0:
           continue
       x[k] = a
       if a not in x[:k] and x[0] == j:
           for b in x[:k+1]:
               print (b, end="")
           print()
           back(k+1)


i = int(input("i = "))
j = int(input("j = "))
x = [0 for i in range(j-i+2)]
back(0)
