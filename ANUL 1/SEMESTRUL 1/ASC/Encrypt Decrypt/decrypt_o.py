import sys
import hashlib

hashedSecretPassword = "3f1a2bcaca2f02a8cd826b57caa7fa8a3214da1856aedb1a2c24ef29c3ea3771"
errorMessageIncorrectFormat = "The correct format is python decrypt.py <input file name> <password> <output file name>"

#verific daca am numarul potrivit de argumente
if len(sys.argv) < 4:
    print(f"Error to few arguments. {errorMessageIncorrectFormat}")
    sys.exit()
if  len(sys.argv) > 4:
    print(f"Error to many arguments. {errorMessageIncorrectFormat}")
    sys.exit()

#iau argumentele
for i, arg in enumerate(sys.argv):
    if i == 1:
        inputFile = arg
    elif i == 2:
        introducedPassword = arg
    elif i == 3:
        outputFile = arg

#functia de hash-uire gasita pe https://medium.com/@dwernychukjosh/sha256-encryption-with-python-bf216db497f9
def encrypt_string(hash_string):
    sha_signature = \
        hashlib.sha256(hash_string.encode()).hexdigest()
    return sha_signature

#verific daca parola introdusa este egala cu parola corecta
if encrypt_string(introducedPassword) != hashedSecretPassword:
    print(f"Error incorrect password.")
    sys.exit()

#deschid fisierele de input si output
fileIn = open(inputFile, "rb")
fileOut = open(outputFile, "w")
#parcurg fisierul de input si il decriptez caracter cu caracter, pe care le afisez in fisierul de output
positionInPassword = 0
for x in fileIn.read():
    code = x ^ ord(introducedPassword[positionInPassword])
    positionInPassword += 1
    if len(introducedPassword) == positionInPassword:
        positionInPassword = 0
    fileOut.write(chr(code))
