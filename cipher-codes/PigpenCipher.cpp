#include <iostream>
#include <map>
#include <string>
using namespace std;

map<char, string> PIGPEN_CIPHER_KEY = {
    {'A', "🞀"}, {'B', "🞀"}, {'C', "🞁"}, {'D', "🞂"}, {'E', "🞃"},
    {'F', "🞄"}, {'G', "🞅"}, {'H', "🞆"}, {'I', "🞇"}, {'J', "🞈"},
    {'K', "🞉"}, {'L', "🞊"}, {'M', "🞋"}, {'N', "🞌"}, {'O', "🞍"},
    {'P', "🞎"}, {'Q', "🞏"}, {'R', "🞐"}, {'S', "🞑"}, {'T', "🞒"},
    {'U', "🞓"}, {'V', "🞔"}, {'W', "🞕"}, {'X', "🞖"}, {'Y', "🞗"},
    {'Z', "🞘"}
};

map<string, char> PIGPEN_CIPHER_REVERSE_KEY;

void initializeReverseKey() {
    for (auto const& entry : PIGPEN_CIPHER_KEY) {
        PIGPEN_CIPHER_REVERSE_KEY[entry.second] = entry.first;
    }
}

string encryptPigpen(const string& plaintext) {
    string ciphertext;
    for (char letter : plaintext) {
        char upperLetter = toupper(letter);
        if (PIGPEN_CIPHER_KEY.count(upperLetter)) {
            ciphertext += PIGPEN_CIPHER_KEY[upperLetter];
        } else {
            ciphertext += letter;
        }
    }
    return ciphertext;
}

string decryptPigpen(const string& ciphertext) {
    string plaintext;
    for (int i = 0; i < ciphertext.length(); i++) {
        string symbol(1, ciphertext[i]);
        if (PIGPEN_CIPHER_REVERSE_KEY.count(symbol)) {
            plaintext += PIGPEN_CIPHER_REVERSE_KEY[symbol];
        } else {
            plaintext += symbol;
        }
    }
    return plaintext;
}

int main() {
    initializeReverseKey();
    string mode, text;

    cout << "Do you want to encrypt or decrypt? (e/d): ";
    cin >> mode;
    cin.ignore();

    if (mode == "e") {
        cout << "Enter the plaintext: ";
        getline(cin, text);
        string encryptedText = encryptPigpen(text);
        cout << "Encrypted text: " << encryptedText << endl;
    } else if (mode == "d") {
        cout << "Enter the Pigpen cipher text: ";
        getline(cin, text);
        string decryptedText = decryptPigpen(text);
        cout << "Decrypted text: " << decryptedText << endl;
    } else {
        cout << "Invalid option. Please choose 'e' to encrypt or 'd' to decrypt." << endl;
    }

    return 0;
}
