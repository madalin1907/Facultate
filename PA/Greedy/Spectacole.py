import re
import heapq

f = open("evenimente.in")

spectacole = [tuple(re.split("[- ]", linie.rstrip("\n"), maxsplit=2)) for linie in f]
spectacole.sort(key=lambda x: x[0])
print(spectacole, "\n")
f.close()

nr_sali = 1
h = [(spectacole[0][1], nr_sali, [spectacole[0]])]
for spec in spectacole[1:]:
    if spec[0] >= h[0][0]:
        t = heapq.heappop(h)
        t2 = (spec[1], t[1], t[-1] + [spec])
        heapq.heappush(h, t2)

    else:
        nr_sali += 1
        heapq.heappush(h, (spec[1], nr_sali, [spec]))

print(f"{nr_sali} sali")

for sala in h:
    print(*sala[2])
