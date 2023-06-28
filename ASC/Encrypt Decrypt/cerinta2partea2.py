import itertools
import hashlib


def encrypt_string(hash_string):
    sha_signature = \
        hashlib.sha256(hash_string.encode()).hexdigest()
    return sha_signature


def XOR(var, key):
    return bytes(a ^ b for a, b in zip(var, key))


def ECaracterulBun(char1, pozcar, lungime_parola):
    f = open('output_o', 'rb')
    pozcar = pozcar - 1  # Ca sa transformam 1-based in 0 based array index
    data = f.read(lungime_parola)
    while data and len(data) - 1 >= pozcar:
        caractcurent = data[pozcar]
        caractcurent = int.from_bytes(XOR(caractcurent.to_bytes(1, byteorder='big'), ord(char1).to_bytes(1, byteorder='big')), "big")
        if not ((32 <= caractcurent <= 126) or caractcurent == 13 or caractcurent == 10):
            return False
        data = f.read(lungime_parola)
    f.close()
    return True


for LungimeParola in range(10, 16):
    parola = ""
    ParolaGasita = True
    for PozitieParola in range(1, LungimeParola+1):
        AmGasitUnCaracterBunPePozitie = False
        s = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM"
        for Caracter in range(len(s)):
            if not ECaracterulBun(s[Caracter], PozitieParola, LungimeParola):
                continue
            parola = parola + s[Caracter]
            AmGasitUnCaracterBunPePozitie = True
        if not AmGasitUnCaracterBunPePozitie:
            ParolaGasita = False
        parola = parola + ' '
    if ParolaGasita:
        ls = parola.split()
        for element in itertools.product(*ls):
            s = ''.join(element)
            if encrypt_string(s) == '3f1a2bcaca2f02a8cd826b57caa7fa8a3214da1856aedb1a2c24ef29c3ea3771':
                print(s)
