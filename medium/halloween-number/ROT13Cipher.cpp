#include<iostream>
#include<string>
#include<sstream>
using namespace std;

string encrypt(string plainText) {
    string cipherText = "";

    for (int i = 0; i < plainText.length(); i++) {
        if (isupper(plainText[i]))
            cipherText += char(int(plainText[i] + 13 - 65) % 26 + 65);
        else
            cipherText += char(int(plainText[i] + 13 - 97) % 26 + 97);
    }
    
    return cipherText;
}

string decrypt(string cipherText) {
    string plainText = "";

    for (int i = 0; i < cipherText.length(); i++) {
        if (isupper(cipherText[i]))
            plainText += char(int(cipherText[i] - 13 - 65 + 26) % 26 + 65);
        else
            plainText += char(int(cipherText[i] - 13 - 97 + 26) % 26 + 97);
    }

    return plainText;
}

int main() {
    string function;
    string plainText;
    string cipherText;

    cout << "Do you want to encrypt or decrypt text? (encrypt/decrypt)" << endl;
    getline(cin, function);

    if (function.find("encrypt") != string::npos) {
        cout << "Enter the plaintext that you would like to encrypt:" << endl;
        getline(cin, plainText);

        cout << "Encrypting '" << plainText << "' ..." << endl;

        string encryptedText = encrypt(plainText);
        cout << "Encrypted Text: " << encryptedText << endl;
    } else if (function.find("decrypt") != string::npos) {
        cout << "Enter the ciphertext that youwould like to decrypt:" << endl;
        getline(cin, cipherText);

        cout << "Decrypting '" << cipherText << "' ..." << endl;

        string decryptedText = decrypt(cipherText);
        cout << "Decrypted Text: " << decryptedText << endl;
    } else {
        cout << "Error: please re-run and try again" << endl;
    }

    return 0;
}