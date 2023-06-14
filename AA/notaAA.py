# LABORATOR (50% DIN NOTA FINALA)

# ALGORITMI GEOMETRICI (problemele de pe platforma)
# Probleme laborator 1
test_orientare = 10
roby = 10
acoperire_convexa_poligon_stelat = 10

# Probleme laborator 2
punct_in_poligon_convex = 10
pozitia_unui_punct_fata_de_un_poligon = 7
monotonia_unui_poligon = 7

# Probleme laborator 3
pozitia_unui_punct_fata_de_cercul_circumscris_unui_triunghi = 10
muchii_ilegale = 10
intersectii_de_semiplane_orizontale_si_verticale = 10
pozitia_unui_punct_fata_de_semiplane_orizontale_si_verticale = 10

# ALGORITMI GENETICI (proiectul)
proiect_algoritmi_genetici = 10

# ALGORITMI APROXIMATIVI (tema seminar)
tema_seminar = 0


# EXAMEN (50% DIN NOTA FINALA)
nota_examen = 2.18



# CALCULARE NOTA FINALA

# NOTA LABORATOR
nota_laborator1 = 0.2 * test_orientare + 0.3 * roby + 0.5 * acoperire_convexa_poligon_stelat # maxim 10
nota_laborator2 = 0.4 * punct_in_poligon_convex + 0.3 * pozitia_unui_punct_fata_de_un_poligon + 0.3 * monotonia_unui_poligon # maxim 10
nota_laborator3 = 0.1 * pozitia_unui_punct_fata_de_cercul_circumscris_unui_triunghi + 0.1 * muchii_ilegale + 0.4 * intersectii_de_semiplane_orizontale_si_verticale + 0.4 * pozitia_unui_punct_fata_de_semiplane_orizontale_si_verticale # maxim 10

nota_algoritmi_geometrici = nota_laborator1 + nota_laborator2 + nota_laborator3 # maxim 30
nota_algoritmi_genetici = 3 * proiect_algoritmi_genetici # maxim 30
nota_algoritmi_aproximativi = 3 * tema_seminar # maxim 30


nota_laborator = (10 + nota_algoritmi_geometrici + nota_algoritmi_genetici + nota_algoritmi_aproximativi) / 10

nota_finala = (nota_laborator + nota_examen) / 2

print("Nota laborator:", nota_laborator)
print("Nota examen:", nota_examen)
print("Nota finala:", nota_finala, end = " ")
print("(RESTANTA)" if nota_finala < 4.5 else "(TRECUT)")
