#include <iostream>
#include <string>
#include <vector>
#include <bitset>
#include <sstream>

// Base64 encoding table
const std::string base64_chars = 
    "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    "abcdefghijklmnopqrstuvwxyz"
    "0123456789+/";

std::string encodeBase64(const std::string& input) {
    std::string encoded;
    std::vector<uint8_t> bytes(input.begin(), input.end());

    int val = 0, valb = -6;
    for (uint8_t c : bytes) {
        val = (val << 8) + c;
        valb += 8;
        while (valb >= 0) {
            encoded.push_back(base64_chars[(val >> valb) & 0x3F]);
            valb -= 6;
        }
    }
    if (valb > -6) {
        encoded.push_back(base64_chars[((val << 8) >> valb) & 0x3F]);
    }
    while (encoded.size() % 4) {
        encoded.push_back('=');
    }
    return encoded;
}

std::string decodeBase64(const std::string& input) {
    std::string decoded;
    std::vector<int> T(256, -1);
    for (int i = 0; i < 64; i++) {
        T[base64_chars[i]] = i;
    }

    std::vector<uint8_t> bytes;
    int val = 0, valb = -8;
    for (unsigned char c : input) {
        if (T[c] == -1) break;
        val = (val << 6) + T[c];
        valb += 6;
        if (valb >= 0) {
            bytes.push_back(char((val >> valb) & 0xFF));
            valb -= 8;
        }
    }
    decoded.assign(bytes.begin(), bytes.end());
    return decoded;
}

int main() {
    std::string mode, message;
    std::cout << "Do you want to encode or decode? (e/d): ";
    std::cin >> mode;
    std::cin.ignore();

    if (mode == "e") {
        std::cout << "Enter the message to encode: ";
        std::getline(std::cin, message);
        std::string encodedMessage = encodeBase64(message);
        std::cout << "Encoded message: " << encodedMessage << std::endl;
    } else if (mode == "d") {
        std::cout << "Enter the Base64 encoded message to decode: ";
        std::getline(std::cin, message);
        std::string decodedMessage = decodeBase64(message);
        std::cout << "Decoded message: " << decodedMessage << std::endl;
    } else {
        std::cout << "Invalid option. Please choose 'e' to encode or 'd' to decode." << std::endl;
    }

    return 0;
}
