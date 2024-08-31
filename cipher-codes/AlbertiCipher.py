def create_alberti_wheel_mapping(outside_wheel, inside_wheel):
    return {outside_wheel[i]: inside_wheel[i] for i in range(len(outside_wheel))}

def encrypt_alberti(plaintext, outside_wheel, inside_wheel):
    mapping = create_alberti_wheel_mapping(outside_wheel, inside_wheel)
    ciphertext = ''.join([mapping[char.upper()] if char.upper() in mapping else char for char in plaintext])
    return ciphertext

def decrypt_alberti(ciphertext, outside_wheel, inside_wheel):
    reverse_mapping = create_alberti_wheel_mapping(inside_wheel, outside_wheel)
    plaintext = ''.join([reverse_mapping[char] if char in reverse_mapping else char for char in ciphertext])
    return plaintext

def main():
    outside_wheel = input("Enter the characters of the outside wheel: ")
    inside_wheel = input("Enter the characters of the inside wheel: ")

    if len(outside_wheel) != len(inside_wheel):
        print("Error: The outside and inside wheels must have the same length.")
        return

    mode = input("Do you want to encrypt or decrypt? (e/d): ").strip().lower()

    if mode == 'e':
        plaintext = input("Enter the plaintext message: ")
        encrypted_text = encrypt_alberti(plaintext, outside_wheel, inside_wheel)
        print("Encrypted message:", encrypted_text)
    elif mode == 'd':
        ciphertext = input("Enter the encrypted message: ")
        decrypted_text = decrypt_alberti(ciphertext, outside_wheel, inside_wheel)
        print("Decrypted message:", decrypted_text)
    else:
        print("Invalid option. Please choose 'e' to encrypt or 'd' to decrypt.")

if __name__ == "__main__":
    main()
