#include <iostream>
#include <string>
#include <stdexcept>

using namespace std;

int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

int modInverse(int a, int m) {
    for (int x = 1; x < m; x++) {
        if ((a * x) % m == 1) {
            return x;
        }
    }
    return -1; // No modular inverse if return -1
}

string affineEncrypt(const string& text, int a, int b) {
    if (gcd(a, 26) != 1) {
        throw invalid_argument("a and 26 are not coprime, encryption is not possible.");
    }

    string encrypted;
    for (char c : text) {
        if (isalpha(c)) {
            char base = isupper(c) ? 'A' : 'a';
            char encryptedChar = ((a * (c - base) + b) % 26) + base;
            encrypted += encryptedChar;
        } else {
            encrypted += c;
        }
    }
    return encrypted;
}

string affineDecrypt(const string& ciphertext, int a, int b) {
    int a_inv = modInverse(a, 26);
    if (a_inv == -1) {
        throw invalid_argument("a has no modular inverse under 26, decryption is not possible.");
    }

    string decrypted;
    for (char c : ciphertext) {
        if (isalpha(c)) {
            char base = isupper(c) ? 'A' : 'a';
            char decryptedChar = ((a_inv * (c - base - b + 26)) % 26) + base;
            decrypted += decryptedChar;
        } else {
            decrypted += c;
        }
    }
    return decrypted;
}

int main() {
    string mode, text;
    int a, b;

    cout << "Do you want to encode or decode? (e/d): ";
    cin >> mode;
    cin.ignore(); // Ignore the newline character after mode input

    cout << "Enter the value of a: ";
    cin >> a;

    cout << "Enter the value of b: ";
    cin >> b;

    cout << "Enter the text: ";
    cin.ignore();
    getline(cin, text);

    try {
        if (mode == "e") {
            string encryptedText = affineEncrypt(text, a, b);
            cout << "Encrypted text: " << encryptedText << endl;
        } else if (mode == "d") {
            string decryptedText = affineDecrypt(text, a, b);
            cout << "Decoded text: " << decryptedText << endl;
        } else {
            cout << "Invalid option. Please choose 'e' to encode or 'd' to decode." << endl;
        }
    } catch (const invalid_argument& e) {
        cerr << "Error: " << e.what() << endl;
    }

    return 0;
}
