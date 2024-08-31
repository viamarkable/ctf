def encode_hex(text):
    return text.encode('utf-8').hex()

def decode_hex(hex_text):
    bytes_object = bytes.fromhex(hex_text)
    return bytes_object.decode('utf-8')

def main():
    mode = input("Do you want to encode or decode? (e/d): ").strip().lower()

    if mode == 'e':
        text = input("Enter the text to encode: ")
        encoded_text = encode_hex(text)
        print("Encoded text:", encoded_text)
    elif mode == 'd':
        hex_text = input("Enter the hexadecimal text to decode: ")
        try:
            decoded_text = decode_hex(hex_text)
            print("Decoded text:", decoded_text)
        except ValueError:
            print("Invalid hexadecimal input.")
    else:
        print("Invalid option. Please choose 'e' to encode or 'd' to decode.")

if __name__ == "__main__":
    main()