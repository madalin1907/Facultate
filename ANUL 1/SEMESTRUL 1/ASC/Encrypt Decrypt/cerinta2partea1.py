import hashlib

def encrypt_string(hash_string):
    sha_signature = \
        hashlib.sha256(hash_string.encode()).hexdigest()
    return sha_signature

f = open("input_o.txt", "r")
g = open("output_o", "rb")

parola = ""
sir_intrare1 = f.read()
sir_intrare = g.read(1)

i = 0
while i < 15:
    parola += chr(sir_intrare[0] ^ ord(sir_intrare1[i]))
    sir_intrare = g.read(1)
    i += 1
    if encrypt_string(parola) == '3f1a2bcaca2f02a8cd826b57caa7fa8a3214da1856aedb1a2c24ef29c3ea3771':
        print(parola)
        i += 30

g.close()
f.close()
