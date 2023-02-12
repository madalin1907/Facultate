# Echipa
# grupa 143
# Florea Madalin-Alexandru
# Besliu Radu-Stefan
# Militaru Mihai-Alexandru

import sys

# Pentru a rula: python 3.py config_3.txt input_3.txt

# Programul copiază inputul pe ambele benzi ( banda principală și cea de backup )
# La fiecare operație, modificările se efectuează în același timp pe ambele benzi
# Cand se ajunge în starea de accept, sunt comparate cele două benzi și se afișează un mesaj corespunzător

# „getSection”: funcție care returnează liniile unei anumite secțiuni în fișier de intrare
# este folosit pentru a separa secțiuni (stări, sigma, gamma, tranziții, stare de pornire, stare de acceptare, stare de respingere)
def getSection(name, configLines):
    flag = False
    section = []

    for line in configLines:
        if line == name + ":":  # începutul secțiunii
            flag = True
            continue
        if line == "end":  # sfârșitul secțiunii
            flag = False
        if flag == True and line not in section:  # dacă nu am ajuns la sfârșitul secțiunii, anexăm linia fișierui la listă
            section.append(line)

    return section


# „loadFromFile”: funcție care utilizează funcția „getSection”, pentru a încărca secțiunile unui fișier de configurare TM
# și le returnează în liste, împreună cu un cod de eroare dacă fișierul nu este valid
def loadFromFile(fileName):
    configLines = []
    errorCode = 0

    file = open(fileName)

    for line in file:
        line = line.strip().lower()
        if len(line) > 0 and line[0] != "/":  # creăm o listă din fișierul de intrare numai cu
            configLines.append(line)                 # rânduri care sunt diferite de comentarii
                                              # astfel încât să putem trece la funcția „getSection”.

    states = getSection("states", configLines)  # obținerea stărilor TM 
    sigma = getSection("sigma", configLines)  # obținerea alfabetului de intrare al TM
    gamma = getSection("gamma", configLines)  # obținerea alfabetului de bandă al TM
    transitions = getSection("transitions", configLines)  # obținerea tranzițiilor TM
    startState = getSection("start state", configLines)  #obținerea stării de pornire a TM 
    acceptState = getSection("accept state", configLines)  # obținerea stării de acceptare a TM
    rejectState = getSection("reject state", configLines) # obținerea stării de respingere a TM

    # dacă fișierul nu conține exact o stare de pornire, returnăm un cod de eroare
    if len(startState) != 1:
        errorCode = 5
        return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState

    # dacă fișierul nu conține exact o stare de acceptare, returnăm un cod de eroare
    if len(acceptState) != 1:
        errorCode = 6
        return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState

    # dacă fișierul nu conține exact o stare de respingere, returnăm un cod de eroare
    if len(rejectState) != 1:
        errorCode = 7
        return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState

    # dacă fișierul nu conține cel puțin trei stări, inclusiv starea de pornire, starea de acceptare și starea de respingere,
    # returnăm un cod de eroare

    if len(states) < 3:
        errorCode = 1
        return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState
    elif startState[0] not in states or acceptState[0] not in states or rejectState[0] not in states:
        errorCode = 1
        return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState

    # dacă fișierul conține simbolul gol ("_") în alfabetul de intrare sau dacă alfabetul de intrare
    # este gol, returnăm un cod de eroare
    if "_" in sigma or len(sigma) == 0:
        errorCode = 2
        return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState

    # dacă fișierul nu conține simbolul gol ("_") în alfabetul de bandă sau 
    # dacă alfabetul de intrare nu este inclus în alfabetul de bandă sau 
    # dacă alfabetul de bandă este gol, returnăm un cod de eroare
    if "_" not in gamma or len(set(gamma)) != len(set(gamma)|set(sigma)) or len(gamma) == 0:
        errorCode = 3
        return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState

    # dacă fișierul nu conține nicio tranziție, returnăm un cod de eroare
    if len(transitions) == 0:
        errorCode = 4
        return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState
    else:
        for transition in transitions:
            transition = transition.split()
            if len(transition) != 5: # dacă o tranziție nu conține exact 5 elemente, returnăm un cod de eroare
                errorCode = 4
                return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState
            elif transition[0] not in states or transition[1] not in states:  # dacă primele două elemente ale unei tranziții nu sunt stări din fișier , returnăm un cod de eroare
                errorCode = 4
                return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState
            elif transition[0] == acceptState[0] or transition[0] == rejectState[0]:  # dacă prima stare a unei tranziții este fie starea de acceptare, fie starea de respingere, returnăm un cod de eroare
                errorCode = 4
                return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState
            elif transition[2] not in gamma:  # dacă al treilea element al unei tranziții nu este un simbol din alfabetul benzii, returnăm un cod de eroare
                errorCode = 4
                return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState
            elif transition[3] not in gamma and transition[3] != "e":  # dacă al patrulea element al unei tranziții nu este un simbol din alfabetul benzii (excluzând epsilon), returnăm un cod de eroare
                errorCode = 4
                return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState
            elif transition[4] != "l" and transition[4] != "r":  # dacă direcția în care se va mișca în continuare capul nu este nici stânga, nici dreapta, returnăm un cod de eroare
                errorCode = 4
                return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState

    file.close()

    # dacă fișierul de configurare TM este valid, nu returnăm niciun cod de eroare
    return errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState



errorCode, states, sigma, gamma, transitions, startState, acceptState, rejectState = loadFromFile(sys.argv[1])

print()
if errorCode == 1:
    print(f"Sectiunea \"States\" din fisierul \"{sys.argv[1]}\" nu este valida.")
elif errorCode == 2:
    print(f"Sectiunea \"Sigma\" din fisierul \"{sys.argv[1]}\" nu este valida.")
elif errorCode == 3:
    print(f"Sectiunea \"Gamma\" din fisierul \"{sys.argv[1]}\" nu este valida.")
elif errorCode == 4:
    print(f"Sectiunea \"Transitions\" din fisierul \"{sys.argv[1]}\" nu este valida.")
elif errorCode == 5:
    print(f"Sectiunea \"Start state\" din fisierul \"{sys.argv[1]}\" nu este valida.")
elif errorCode == 6:
    print(f"Sectiunea \"Accept state\" din fisierul \"{sys.argv[1]}\" nu este valida.")
elif errorCode == 7:
    print(f"Sectiunea \"Reject state\" din fisierul \"{sys.argv[1]}\" nu este valida.")
else:
    print(f"Fisierul \"{sys.argv[1]}\" este valid! Masina Turing acceptata!")
    print()

    inputTM = open(sys.argv[2])

    # este testat fiecare input din fisier
    for line in inputTM:
        print("----------------------------------")
        validInput = True # variabilă care indică dacă input-ul este valid

        # sunt setate cele 3 stări : starea curentă, starea de accept, starea de reject 
        currentS = startState[0]
        acceptS = acceptState[0]
        rejectS = rejectState[0]

        # tranzitiile sunt transformate din string-uri in array-uri folosind split
        newTransitions = [transition.split() for transition in transitions]

        # pozitia curentă pe bandă
        currentPosition = 0

        line = line.strip()
        line += '_'

        # se creează cele două benzi ( cea principală și cea de backup )
        tape = [char for char in line]
        tape2 = [char for char in line]

        # se execută operații pe bandă cat timp nu se ajunge din una din stările de reject sau accept
        # sau cat timp nu este aruncată vreo eroare
        while currentS != acceptS and currentS != rejectS:
            try:
                newTransition = [transition for transition in newTransitions if transition[0] == currentS and transition[2] == tape[currentPosition]][0]
                if newTransition[1] == rejectS:
                    raise # aruncăm eroare dacă suntem in starea de reject
            except:
                print(f'Sirul "{line[0:-1]}" din "{sys.argv[2]}" nu este acceptat de masina!')
                validInput = False
                break

            # se setează litera din tranzitie la pozitia curentă pe bandă
            tape[currentPosition] = newTransition[3]
            tape2[currentPosition] = newTransition[3]

            # aici sunt definete cele două direcții de miscare pe bandă ( stânga și dreapta )
            if (newTransition[4] == 'l'):
                currentPosition -= 1
            if (newTransition[4] == 'r'):
                currentPosition += 1
            currentS = newTransition[1]

        if validInput:
            print(f'Sirul "{line[0:-1]}" din "{sys.argv[2]}" este acceptat de masina!')
            # se verifică egalitatea celor două benzi
            if tape == tape2:
                print("Benzile sunt identice.")
            else:
                print("Benzile nu sunt identice. Exista diferențe intre banda principala si cea de backup.")
                
    print("----------------------------------")

    inputTM.close()
