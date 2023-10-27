teme_obligatorii = float(3.81)
teme_suplimentare = float(1.1)
colocviu = float(0.9)
examen = float(5)

nota_laborator = teme_obligatorii + min(6, max(teme_suplimentare, (teme_suplimentare / 3) + colocviu))

nota_finala = 0.6 * nota_laborator + 0.4 * examen

print(f"\nNota laborator: {nota_laborator}")
print(f"Nota examen: {examen}")
print(f"Nota finala: {nota_finala}", end=" ")

if nota_laborator < 5 or examen < 5:
    print(f"(restanta)\n")
