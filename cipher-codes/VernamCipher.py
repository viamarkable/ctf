def encrypt(plaintext, key):
    if len(plaintext) != len(key):
        raise ValueError("The length of the key must be equal to the length of the plaintext.")

    ciphertext = []
    for p, k in zip(plaintext, key):
        cipher_char = chr(ord(p) ^ ord(k))
        ciphertext.append(cipher_char)
    
    return ''.join(ciphertext)

def decrypt(ciphertext, key):
    if len(ciphertext) != len(key):
        raise ValueError("The length of the key must be equal to the length of the ciphertext.")
    
    plaintext = []
    for c, k in zip(ciphertext, key):
        plain_char = chr(ord(c) ^ ord(k))
        plaintext.append(plain_char)
    
    return ''.join(plaintext)

mode = input("Do you want to encrypt or decrypt? (e/d): ").strip().lower()
text = input("Enter the plaintext or ciphertext: ")
key = input("Enter the key: ")

if mode == 'e':
    encrypted_text = encrypt(text, key)
    print("Encrypted text:", encrypted_text)
elif mode == 'd':
    decrypted_text = decrypt(text, key)
    print("Decrypted text:", decrypted_text)
else:
    print("Invalid option. Please choose 'e' to encrypt or 'd' to decrypt.")