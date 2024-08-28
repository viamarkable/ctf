def encrypt(plainText, key):
    result = ""

    for i in range(len(plainText)):
        char = plainText[i]

        if (char.isupper()):
            result += chr((ord(char) + key - 65) % 26 + 65)

        else:
            result += chr((ord(char) + key - 97) % 26 + 97)

    return result

def decrypt(cipherText, key):
    result = ""

    for i in range(len(cipherText)):
        char = cipherText[i]

        if (char.isupper()):
            result += chr((ord(char) + key - 65 + 26) % 26 + 65)

        else:
            result += chr((ord(char) + key - 97 + 26) % 26 + 97)

    return result

question = input('Do you want to encrypt or decrypt text? (encrypt/decrypt)')

if question == 'encrypt':
    plainText = input('Enter the plaintext that you would like to encrypt:')
    key = input('Enter the key you would like to use for encryption:')

    print("Encrypting '" + plainText + "' ...")

    encryptedText = encrypt(plainText, key)
    print("Encrypted Text: " + encryptedText)
elif question == 'decrypt':
    cipherText = input('Enter the ciphertext that you would like to decrypt:')
    keyQuestion = input('Do you know the key that was used for encryption? (y/n)')

    if keyQuestion == 'y':
        key = input('Enter the key use for encryption:')

        print("Decrypting '" + cipherText + "' ...")
        
        decryptedText = decrypt(cipherText, key)
        print("Decrypted Text: " + decryptedText)
    elif keyQuestion == 'n':
        print("Decrypting '" + cipherText + "' through brute force...")

        for i in range(26):
            key = i
            bruteForceResult = decrypt(cipherText, key)

            print("Key " + (i+1) + ": " + bruteForceResult)