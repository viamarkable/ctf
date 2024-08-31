def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

def mod_inverse(a, m):
    for x in range(1, m):
        if (a * x) % m == 1:
            return x
    return None

def affine_encrypt(text, a, b):
    if gcd(a, 26) != 1:
        raise ValueError(f"a ({a}) and 26 are not coprime, encryption is not possible.")
    
    encrypted = ""
    for char in text:
        if char.isalpha():
            char_base = 'A' if char.isupper() else 'a'
            encrypted_char = chr(((a * (ord(char) - ord(char_base)) + b) % 26) + ord(char_base))
            encrypted += encrypted_char
        else:
            encrypted += char
    return encrypted

def affine_decrypt(ciphertext, a, b):
    a_inv = mod_inverse(a, 26)
    if a_inv is None:
        raise ValueError(f"a ({a}) has no modular inverse under 26, decryption is not possible.")
    
    decrypted = ""
    for char in ciphertext:
        if char.isalpha():
            char_base = 'A' if char.isupper() else 'a'
            decrypted_char = chr(((a_inv * (ord(char) - ord(char_base) - b)) % 26) + ord(char_base))
            decrypted += decrypted_char
        else:
            decrypted += char
    return decrypted

def main():
    mode = input("Do you want to encode or decode? (e/d): ").strip().lower()

    a = int(input("Enter the value of a: "))
    b = int(input("Enter the value of b: "))
    text = input("Enter the text: ")

    if mode == 'e':
        encrypted_text = affine_encrypt(text, a, b)
        print("Encrypted text:", encrypted_text)
    elif mode == 'd':
        decrypted_text = affine_decrypt(text, a, b)
        print("Decrypted text:", decrypted_text)
    else:
        print("Invalid option. Please choose 'e' to encode or 'd' to decode.")

if __name__ == "__main__":
    main()
