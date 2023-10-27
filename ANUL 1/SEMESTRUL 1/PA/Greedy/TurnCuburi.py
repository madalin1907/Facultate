f = open("cuburi.txt", "r")
g = open("turn.txt", "w")

nrcuburi = int(f.readline())
ls = []

for i in range(nrcuburi):
    s = f.readline().split()
    ls.append([int(s[0]), s[1]])
ls = sorted(ls, key=lambda x: -(x[0]))

culoare = ""
inaltime = 0
for cub in ls:
    if culoare != cub[1] or culoare == "":
        g.write(f"{cub[0]} {cub[1]}\n")
        inaltime += cub[0]
        culoare = cub[1]

g.write(f"Inaltimea turnului este {inaltime}.")

f.close()
g.close()
