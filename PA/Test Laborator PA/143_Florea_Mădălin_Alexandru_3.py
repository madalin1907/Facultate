'''
Nume: Florea
Prenume: Mădălin-Alexandru
Grupa: 143

Enunț:
Alice și Bob comunică folosind următorul algoritm pentru a-și codifica mesajele:
● Alice și Bob cunosc amândoi o cheie secretă sub forma unui șir de caractere care este o
permutare a celor 26 de litere mici din alfabetul englez, astfel: literei 'a' îi corespunde prima
literă din cheia secretă, literei 'b' îi corespunde a doua literă din cheia secretă, ..., literei 'z' îi
corespunde ultima literă din cheia secretă, după cum se poate observa din următorul
exemplu:
Alfabetul englez = a b c d e f g h i j k l m n o p q r s t u v w x y z
 Cheia secretă = o b c g s e f h i z j k l m n p q r d t u v a w x y
● Codificarea unui mesaj presupune înlocuirea fiecărei litere din el cu litera corespunzătoare
din cheia secretă. De exemplu, dacă Alice și Bob au cheia secretă
"obcgsefhizjklmnpqrdtuvawxy", atunci cuvântul "astazi" se va codifica prin cuvântul
"odtoyi", deoarece literei 'a' îi corespunde litera 'o', literei 's' îi corespunde litera 'd' ș.a.m.d.
● Decodificarea unui mesaj codificat presupune căutarea fiecărei litere din el în cheia secretă și
înlocuirea ei cu litera corespunzătoare din alfabetul englez. De exemplu, dacă Alice și Bob au
cheia secretă "obcgsefhizjklmnpqrdtuvawxy", atunci cuvântul codificat "endt" se va
decodifica în cuvântul "fost", deoarece literei 'e' îi corespunde litera 'f', literei 'n' îi
corespunde litera 'o' ș.a.m.d.
Mesajele sunt codificate și transmise cuvânt cu cuvânt. Toate literele din mesaje sunt litere mici
din alfabetul englez și nu se folosesc semne de punctuație, cu excepția caracterului ‘-’, care nu se
criptează.
Eve este un hacker care interceptează traficul și reușește să găsească algoritmul de decodificare,
precum și cheia secretă. Eve are dificultăți în reconstrucția propozițiilor deoarece nu salvează
cuvintele în ordinea în care sunt trimise. Să se reconstruiască propozițiile trimise de Alice și Bob.
a) [1 p.] Fișierul text comunicare.in are următoarea structură:
• pe prima linie se găsește cheia secretă
• pe fiecare dintre următoarele linii se găsesc informațiile despre un cuvânt (transmis la cel
puțin un minut distanță), despărțite printr-un spațiu astfel:
▪ primul caracter este A dacă cuvântul este trimis de Alice sau B dacă este trimis de Bob
▪ separat printr-un spațiu se va găsi cuvântul în formă codificată
▪ ultima informație va fi ora la care este trimis mesajul în format de 5 caractere și 24 de
ore (de exemplu, 12:34 sau 21:03)
Să se scrie o funcție citire_date care să returneze o structură cu datele din fișier.
b) [1.5 p.] Să se scrie o funcție decodificare care primește ca parametri un cuvânt codificat și
cheia secretă utilizată. Funcția trebuie să decodifice eficient cuvântul codificat și apoi să-l
returneze.
[1.5 p.] Să se reconstituie propozițiile trimise de Bob și Alice astfel :
• se decodifică fiecare cuvânt folosind funcția definită la punctul b)
• se determină ordinea în care au fost trimise cuvintele
• se salvează în fișierul text comunicare.out propozițiile reconstituite, astfel:
'''

#a
def citire_date():
    f = open("comunicare.in", "r")
    cheie = f.readline().rstrip()
    repliciA = []
    repliciB = []
    for linie in f.readlines():
        replica = linie.split()
        if replica[0] == 'A':
            repliciA.append([replica[1], replica[2]])
        else:
            repliciB.append([replica[1], replica[2]])

    f.close()
    return (cheie, repliciA, repliciB)


#b
def decodificare(cuvant, cheie):
    alfabet = "abcdefghijklmnopqrstuvwxyz"
    decod = ""

    for litera in cuvant:
        if litera.isalpha():
            decod += alfabet[cheie.index(litera)]
        else:
            decod += '-'

    return decod

#c
structura = citire_date()

cheie = structura[0]
repliciA = sorted(structura[1], key=lambda x: x[1])
repliciB = sorted(structura[2], key=lambda x: x[1])

propA = []
for cuvant in repliciA:
    propA.append(decodificare(cuvant[0], cheie))
propB = []
for cuvant in repliciB:
    propB.append(decodificare(cuvant[0], cheie))

g = open("comunicare.out", "w")
g.write("A : " + " ".join(propA) + "\n")
g.write("B : " + " ".join(propB))
g.close()
