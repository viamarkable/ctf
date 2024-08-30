#include<iostream>
#include<string>
#include<sstream>
#include<map>
using namespace std;

map<char, char> lookup_table = {
    { 'A', 'Z' },
    { 'B', 'Y' }, 
    { 'C', 'X' }, 
    { 'D', 'W' },
    { 'E', 'V' }, 
    { 'F', 'U' }, 
    { 'G', 'T' }, 
    { 'H', 'S' },
    { 'I', 'R' }, 
    { 'J', 'Q' }, 
    { 'K', 'P' }, 
    { 'L', 'O' },
    { 'M', 'N' }, 
    { 'N', 'M' }, 
    { 'O', 'L' }, 
    { 'P', 'K' },
    { 'Q', 'J' }, 
    { 'R', 'I' }, 
    { 'S', 'H' }, 
    { 'T', 'G' },
    { 'U', 'F' }, 
    { 'V', 'E' }, 
    { 'W', 'D' }, 
    { 'X', 'C' },
    { 'Y', 'B' }, 
    { 'Z', 'A' }

};

string mirror(string message) {
    string cipher = "";
    for(char letter : message) {
        if(letter != ' ')
            {
                cipher += lookup_table[toupper(letter)];
            }
            else
            {
                cipher += ' ';
            }
        return cipher;
    }
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

        string encryptedText = mirror(plainText);
        cout << "Encrypted Text: " << encryptedText << endl;
    } else if (function.find("decrypt") != string::npos) {
        cout << "Enter the ciphertext that youwould like to decrypt:" << endl;
        getline(cin, cipherText);

        cout << "Decrypting '" << cipherText << "' ..." << endl;

        string decryptedText = mirror(cipherText);
        cout << "Decrypted Text: " << decryptedText << endl;
    } else {
        cout << "Error: please re-run and try again" << endl;
    }

    return 0;
}