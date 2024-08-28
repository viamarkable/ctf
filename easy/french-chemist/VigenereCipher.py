def generateKey(text, key):
    key = list(key)
    if len(text) == len(key):
        return key
    else:
        for i in range(len(text) - len(key)):
            key.append(key[i % len(key)])
    return "".join(key)

def encrypt(plainText, key):
    encryptedText = []
    key = generateKey(plainText, key)
    for i in range(len(plainText)):
        char = plainText[i]
        if char.isupper():
            encryptedChar = chr((ord(char) + ord(key[i]) - 2 * ord('A')) % 26 + ord('A'))
        elif char.islower():
            encryptedChar = chr((ord(char) + ord(key[i]) - 2 * ord('a')) % 26 + ord('a'))
        else:
            encryptedChar = char
        encryptedText.append(encryptedChar)
    return "".join(encryptedText)

def decrypt(cipherText, key):
    decryptedText = []
    key = generateKey(cipherText, key)
    for i in range(len(cipherText)):
        char = cipherText[i]
        if char.isupper():
            decryptedChar = chr((ord(char) - ord(key[i]) + 26) % 26 + ord('A'))
        elif char.islower():
            decryptedChar = chr((ord(char) - ord(key[i]) + 26) % 26 + ord('a'))
        else:
            decryptedChar = char
        decryptedText.append(decryptedChar)
    return "".join(decryptedText)

question = input('Do you want to encrypt or decrypt text? (encrypt/decrypt) ')

if question.startswith('e'):
    plainText = input('Enter the plaintext that you would like to encrypt: ')
    key = input('Enter the key you would like to use for encryption: ')

    print("Encrypting '" + plainText + "' ...")

    encryptedText = encrypt(plainText, key)
    print("Encrypted Text: " + encryptedText)
elif question.startswith('d'):
    cipherText = input('Enter the ciphertext that you would like to decrypt: ')
    key = input('Enter the key used for encryption: ')

    print("Decrypting '" + cipherText + "' ...")
        
    decryptedText = decrypt(cipherText, key)
    print("Decrypted Text: " + decryptedText)
else:
    pass