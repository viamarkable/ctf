# Morse code dictionary
MORSE_CODE_DICT = {
    'A': '.-', 'B': '-...', 'C': '-.-.', 'D': '-..', 'E': '.', 'F': '..-.',
    'G': '--.', 'H': '....', 'I': '..', 'J': '.---', 'K': '-.-', 'L': '.-..',
    'M': '--', 'N': '-.', 'O': '---', 'P': '.--.', 'Q': '--.-', 'R': '.-.',
    'S': '...', 'T': '-', 'U': '..-', 'V': '...-', 'W': '.--', 'X': '-..-',
    'Y': '-.--', 'Z': '--..', '1': '.----', '2': '..---', '3': '...--',
    '4': '....-', '5': '.....', '6': '-....', '7': '--...', '8': '---..',
    '9': '----.', '0': '-----', ', ': '--..--', '.': '.-.-.-', '?': '..--..',
    '/': '-..-.', '-': '-....-', '(': '-.--.', ')': '-.--.-', ' ': '/'
}

MORSE_CODE_REVERSE_DICT = {value: key for key, value in MORSE_CODE_DICT.items()}

def encrypt(plaintext):
    ciphertext = []
    for letter in plaintext.upper():
        if letter in MORSE_CODE_DICT:
            ciphertext.append(MORSE_CODE_DICT[letter])
        else:
            ciphertext.append('?')
    return ' '.join(ciphertext)

def decrypt(ciphertext):
    words = ciphertext.split(' / ')
    plaintext = []
    for word in words:
        letters = word.split()
        for letter in letters:
            if letter in MORSE_CODE_REVERSE_DICT:
                plaintext.append(MORSE_CODE_REVERSE_DICT[letter])
            else:
                plaintext.append('?')
        plaintext.append(' ')
    return ''.join(plaintext).strip()

def main():
    mode = input("Do you want to encrypt or decrypt? (e/d): ").strip().lower()
    
    if mode == 'e':
        text = input("Enter the plaintext: ")
        encrypted_text = encrypt(text)
        print("Encrypted Morse code:", encrypted_text)
    elif mode == 'd':
        text = input("Enter the Morse code (use '/' for space between words): ")
        decrypted_text = decrypt(text)
        print("Decrypted text:", decrypted_text)
    else:
        print("Invalid option. Please choose 'e' to encrypt or 'd' to decrypt.")

if __name__ == "__main__":
    main()