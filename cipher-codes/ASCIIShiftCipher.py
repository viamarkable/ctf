def ascii_shift_cipher(text, shift, mode):
    result = ""
    if mode == 'd':
        shift = -shift

    for char in text:
        shifted_char = chr((ord(char) + shift) % 128)
        result += shifted_char

    return result

def main():
    mode = input("Do you want to encode or decode? (e/d): ").strip().lower()
    if mode not in ['e', 'd']:
        print("Invalid option. Please choose 'e' to encode or 'd' to decode.")
        return

    text = input("Enter the text: ")
    shift = int(input("Enter the shift value (0-127): "))

    if shift < 0 or shift > 127:
        print("Error: Shift value must be between 0 and 127.")
        return

    result = ascii_shift_cipher(text, shift, mode)
    print(f"Result: {result}")

if __name__ == "__main__":
    main()
