lookup_table = {'A' : 'Z', 
                'B' : 'Y', 
                'C' : 'X', 
                'D' : 'W', 
                'E' : 'V', 
                'F' : 'U', 
                'G' : 'T', 
                'H' : 'S', 
                'I' : 'R', 
                'J' : 'Q',	
                'K' : 'P', 
                'L' : 'O', 
                'M' : 'N', 
                'N' : 'M', 
                'O' : 'L', 
                'P' : 'K', 
                'Q' : 'J', 
                'R' : 'I', 
                'S' : 'H', 
                'T' : 'G', 
                'U' : 'F', 
                'V' : 'E', 
                'W' : 'D', 
                'X' : 'C', 
                'Y' : 'B', 
                'Z' : 'A'}

def mirror(message) :
    cipher = ''

    for letter in message:
        if(letter != ' '):
            cipher += lookup_table[letter]
        else:
            cipher += ' '
    
    return cipher

question = input('Do you want to encrypt or decrypt text? (encrypt/decrypt) ')

if question == 'encrypt':
    plainText = input('Enter the plaintext that you would like to encrypt: ')

    print("Encrypting '" + plainText + "' ...")

    encryptedText = mirror(plainText)
    print("Encrypted Text: " + encryptedText)
elif question == 'decrypt':
    cipherText = input('Enter the ciphertext that you would like to decrypt: ')
    
    print("Decrypting '" + cipherText + "' ...")
        
    decryptedText = mirror(cipherText)
    print("Decrypted Text: " + decryptedText)