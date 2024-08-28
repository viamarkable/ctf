def encrypt(plainText):
    result = ""

    for i in range(len(plainText)):
        char = plainText[i]

        if (char.isupper()):
            result += chr((ord(char) + 13 - 65) % 26 + 65)

        else:
            result += chr((ord(char) + 13 - 97) % 26 + 97)

    return result

def decrypt(cipherText):
    result = ""

    for i in range(len(cipherText)):
        char = cipherText[i]

        if (char.isupper()):
            result += chr((ord(char) - 13 - 65 + 26) % 26 + 65)

        else:
            result += chr((ord(char) - 13 - 97 + 26) % 26 + 97)

    return result

question = input('Do you want to encrypt or decrypt text? (encrypt/decrypt) ')

if question == 'encrypt':
    plainText = input('Enter the plaintext that you would like to encrypt: ')

    print("Encrypting '" + plainText + "' ...")

    encryptedText = encrypt(plainText)
    print("Encrypted Text: " + encryptedText)
elif question == 'decrypt':
    cipherText = input('Enter the ciphertext that you would like to decrypt: ')
    
    print("Decrypting '" + cipherText + "' ...")
        
    decryptedText = decrypt(cipherText)
    print("Decrypted Text: " + decryptedText)