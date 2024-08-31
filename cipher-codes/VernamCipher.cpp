#include <iostream>
#include <string>
using namespace std;

string encrypt(const string& plaintext, const string& key) {
    if (plaintext.length() != key.length()) {
        throw invalid_argument("The length of the key must be equal to the length of the plaintext.");
    }

    string ciphertext;
    for (size_t i = 0; i < plaintext.length(); i++) {
        char p = plaintext[i];
        char k = key[i];
        char cipherChar = p ^ k;
        ciphertext += cipherChar;
    }

    return ciphertext;
}

string decrypt(const string& ciphertext, const string& key) {
    if (ciphertext.length() != key.length()) {
        throw invalid_argument("The length of the key must be equal to the length of the ciphertext.");
    }

    string plaintext;
    for (size_t i = 0; i < ciphertext.length(); i++) {
        char c = ciphertext[i];
        char k = key[i];
        char plainChar = c ^ k;
        plaintext += plainChar;
    }

    return plaintext;
}

int main() {
    string mode, text, key;

    cout << "Do you want to encrypt or decrypt? (e/d): ";
    cin >> mode;
    cin.ignore();

    cout << "Enter the plaintext or ciphertext: ";
    getline(cin, text);

    cout << "Enter the key: ";
    getline(cin, key);

    try {
        if (mode == "e") {
            string encryptedText = encrypt(text, key);
            cout << "Encrypted text: " << encryptedText << endl;
        } else if (mode == "d") {
            string decryptedText = decrypt(text, key);
            cout << "Decrypted text: " << decryptedText << endl;
        } else {
            cout << "Invalid option. Please choose 'e' to encrypt or 'd' to decrypt." << endl;
        }
    } catch (const invalid_argument& e) {
        cout << "Error: " << e.what() << endl;
    }

    return 0;
}
