def create_polybius_grid(key):
    grid = {}
    index = 0
    for row in range(5):
        for col in range(5):
            if index < len(key):
                grid[key[index]] = (row + 1, col + 1)
                index += 1
    return grid

def reverse_polybius_grid(grid):
    reverse_grid = {}
    for letter, (row, col) in grid.items():
        reverse_grid[(row, col)] = letter
    return reverse_grid

def encrypt_polybius(plaintext, grid):
    ciphertext = ""
    for char in plaintext.upper():
        if char in grid:
            row, col = grid[char]
            ciphertext += str(row) + str(col)
        else:
            ciphertext += char
    return ciphertext

def decrypt_polybius(ciphertext, reverse_grid):
    plaintext = ""
    i = 0
    while i < len(ciphertext):
        if ciphertext[i].isdigit() and (i + 1) < len(ciphertext) and ciphertext[i + 1].isdigit():
            row = int(ciphertext[i])
            col = int(ciphertext[i + 1])
            plaintext += reverse_grid.get((row, col), '')
            i += 2
        else:
            plaintext += ciphertext[i]
            i += 1
    return plaintext

def main():
    key = input("Enter the characters of the Polybius grid (25 unique characters): ").upper()
    
    if len(set(key)) != 25:
        print("Error: The key must contain 25 unique characters.")
        return

    polybius_grid = create_polybius_grid(key)
    reverse_grid = reverse_polybius_grid(polybius_grid)
    
    mode = input("Do you want to encrypt or decrypt? (e/d): ").strip().lower()
    
    if mode == 'e':
        plaintext = input("Enter the plaintext message: ")
        encrypted_message = encrypt_polybius(plaintext, polybius_grid)
        print("Encrypted message:", encrypted_message)
    elif mode == 'd':
        ciphertext = input("Enter the ciphertext message: ")
        decrypted_message = decrypt_polybius(ciphertext, reverse_grid)
        print("Decrypted message:", decrypted_message)
    else:
        print("Invalid option. Please choose 'e' to encrypt or 'd' to decrypt.")

if __name__ == "__main__":
    main()