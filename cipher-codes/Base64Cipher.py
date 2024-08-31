import base64

def encode_base64(message):
    message_bytes = message.encode('utf-8')
    base64_bytes = base64.b64encode(message_bytes)
    base64_message = base64_bytes.decode('utf-8')
    return base64_message

def decode_base64(base64_message):
    base64_bytes = base64_message.encode('utf-8')
    message_bytes = base64.b64decode(base64_bytes)
    message = message_bytes.decode('utf-8')
    return message

def main():
    mode = input("Do you want to encode or decode? (e/d): ").strip().lower()

    if mode == 'e':
        message = input("Enter the message to encode: ")
        encoded_message = encode_base64(message)
        print("Encoded message:", encoded_message)
    elif mode == 'd':
        base64_message = input("Enter the Base64 encoded message to decode: ")
        decoded_message = decode_base64(base64_message)
        print("Decoded message:", decoded_message)
    else:
        print("Invalid option. Please choose 'e' to encode or 'd' to decode.")

if __name__ == "__main__":
    main()
