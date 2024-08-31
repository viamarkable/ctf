PIGPEN_CIPHER_KEY = {
    'A': '🞀', 'B': '🞀', 'C': '🞁', 'D': '🞂', 'E': '🞃', 'F': '🞄',
    'G': '🞅', 'H': '🞆', 'I': '🞇', 'J': '🞈', 'K': '🞉', 'L': '🞊',
    'M': '🞋', 'N': '🞌', 'O': '🞍', 'P': '🞎', 'Q': '🞏', 'R': '🞐',
    'S': '🞑', 'T': '🞒', 'U': '🞓', 'V': '🞔', 'W': '🞕', 'X': '🞖',
    'Y': '🞗', 'Z': '🞘'
}

PIGPEN_CIPHER_REVERSE_KEY = {value: key for key, value in PIGPEN_CIPHER_KEY.items()}

def encrypt_pigpen(plaintext):
    ciphertext = []
    for letter in plaintext.upper():
        if letter in PIGPEN_CIPHER_KEY:
            ciphertext.append(PIGPEN_CIPHER_KEY[letter])
        else:
            ciphertext.append(letter)
    return ''.join(ciphertext)

def decrypt_pigpen(ciphertext):
    plaintext = []
    for symbol in ciphertext:
        if symbol in PIGPEN_CIPHER_REVERSE_KEY:
            plaintext.append(PIGPEN_CIPHER_REVERSE_KEY[symbol])
        else:
            plaintext.append(symbol)
    return ''.join(plaintext)

def main():
    mode = input("Do you want to encrypt or decrypt? (e/d): ").strip().lower()
    
    if mode == 'e':
        text = input("Enter the plaintext: ")
        encrypted_text = encrypt_pigpen(text)
        print("Encrypted text:", encrypted_text)
    elif mode == 'd':
        text = input("Enter the ciphertext: ")
        decrypted_text = decrypt_pigpen(text)
        print("Decrypted text:", decrypted_text)
    else:
        print("Invalid option. Please choose 'e' to encrypt or 'd' to decrypt.")

if __name__ == "__main__":
    main()
