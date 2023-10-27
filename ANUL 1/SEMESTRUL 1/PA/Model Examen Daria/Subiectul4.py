#a
def back(k):
    if k == s:
        #b: if 1 in x and nrf+1 in x:
            print(*x)
    else:
        if k < s//2:
            if k == 0:
                start = 1
            else:
                start = x[k-1] + 1
            stop = nrf + 1
        else:
            if k == s//2:
                start = nrf + 1
            else:
                start = x[k-1] + 1
            stop = nrf + nrb + 1

        for i in range(start, stop):
            x[k] = i
            back(k+1)


nrf = int(input("Nr. fete: "))
nrb = int(input("Nr. baieti: "))
s = int(input("Nr. studenti per grupa: "))

if nrf < s//2 or nrb < s//2:
    print("Nu se poate.")
else:
    x = [0 for i in range(s)]
    back(0)
