#include<iostream>
#include<string>
#include<sstream>
using namespace std;

string encrypt(string plainText, int s) {
    string cipherText = "";

    for (int i = 0; i < plainText.length(); i++) {
        if (isupper(plainText[i]))
            cipherText += char(int(plainText[i] + s - 65) % 26 + 65);
        else
            cipherText += char(int(plainText[i] + s - 97) % 26 + 97);
    }
    
    return cipherText;
}

string decrypt(string cipherText, int s) {
    string plainText = "";

    for (int i = 0; i < cipherText.length(); i++) {
        if (isupper(cipherText[i]))
            plainText += char(int(cipherText[i] - s - 65 + 26) % 26 + 65);
        else
            plainText += char(int(cipherText[i] - s - 97 + 26) % 26 + 97);
    }

    return plainText;
}

int main() {
    string function;
    string plainText;
    string cipherText;
    int key = 1;

    cout << "Do you want to encrypt or decrypt text? (encrypt/decrypt)" << endl;
    getline(cin, function);

    if (function.find("encrypt") != string::npos) {
        cout << "Enter the plaintext that you would like to encrypt:" << endl;
        getline(cin, plainText);

        cout << "Enter the shift you would like to use for encryption:" << endl;
        cin >> key;
        cin.ignore();

        cout << "Encrypting '" << plainText << "' ..." << endl;

        string encryptedText = encrypt(plainText, key);
        cout << "Encrypted Text: " << encryptedText << endl;
    } else if (function.find("decrypt") != string::npos) {
        cout << "Enter the ciphertext that youwould like to decrypt:" << endl;
        getline(cin, cipherText);

        cout << "Do you know the shift that was used for encryption? (y/n)" << endl;
        string aKey;
        getline(cin, aKey);

        if (aKey.find("y") != string::npos) {
            cout << "Enter the shift used for encryption:" << endl;
            cin >> key;
            cin.ignore();

            cout << "Decrypting '" << cipherText << "' ..." << endl;

            string decryptedText = decrypt(cipherText, key);
            cout << "Decrypted Text: " << decryptedText << endl;
        } else {
            cout << "Decrypting '" << cipherText << "' through brute force..." << endl;

            for (int i = 0; i < 26; i++) {
                string bruteForceResult = decrypt(cipherText, i);
                cout << "Shift of " << i << ": " << bruteForceResult << endl;
            }
        }
    } else {
        cout << "Error: please re-run and try again" << endl;
    }

    return 0;
}