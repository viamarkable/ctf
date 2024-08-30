#include<iostream>
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

int question;

cout << "Do you want to encrypt or decrypt text? (encrypt/decrypt)";
cin >> question;