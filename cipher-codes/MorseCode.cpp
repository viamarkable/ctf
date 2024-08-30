#include <iostream>
#include <map>
#include <sstream>

using namespace std;

map<char, string> MORSE_CODE_DICT = {
    {'A', ".-"}, {'B', "-..."}, {'C', "-.-."}, {'D', "-.."}, {'E', "."},
    {'F', "..-."}, {'G', "--."}, {'H', "...."}, {'I', ".."}, {'J', ".---"},
    {'K', "-.-"}, {'L', ".-.."}, {'M', "--"}, {'N', "-."}, {'O', "---"},
    {'P', ".--."}, {'Q', "--.-"}, {'R', ".-."}, {'S', "..."}, {'T', "-"},
    {'U', "..-"}, {'V', "...-"}, {'W', ".--"}, {'X', "-..-"}, {'Y', "-.--"},
    {'Z', "--.."}, {'1', ".----"}, {'2', "..---"}, {'3', "...--"},
    {'4', "....-"}, {'5', "....."}, {'6', "-...."}, {'7', "--..."},
    {'8', "---.."}, {'9', "----."}, {'0', "-----"}, {',', "--..--"},
    {'.', ".-.-.-"}, {'?', "..--.."}, {'/', "-..-."}, {'-', "-....-"},
    {'(', "-.--."}, {')', "-.--.-"}, {' ', "/"}
};

map<string, char> MORSE_CODE_REVERSE_DICT;

void initializeReverseDict() {
    for (const auto &entry : MORSE_CODE_DICT) {
        MORSE_CODE_REVERSE_DICT[entry.second] = entry.first;
    }
}

string encryptToMorse(const string &plaintext) {
    stringstream ciphertext;
    for (char letter : plaintext) {
        char upperLetter = toupper(letter);
        if (MORSE_CODE_DICT.count(upperLetter)) {
            ciphertext << MORSE_CODE_DICT[upperLetter] << " ";
        } else {
            ciphertext << "? ";
        }
    }
    return ciphertext.str();
}

string decryptFromMorse(const string &morseCode) {
    stringstream plaintext;
    stringstream morseStream(morseCode);
    string word;
    
    while (getline(morseStream, word, '/')) {
        stringstream wordStream(word);
        string letter;
        while (wordStream >> letter) {
            if (MORSE_CODE_REVERSE_DICT.count(letter)) {
                plaintext << MORSE_CODE_REVERSE_DICT[letter];
            } else {
                plaintext << "?";
            }
        }
        plaintext << " ";
    }
    
    return plaintext.str();
}

int main() {
    initializeReverseDict();

    string mode, text;

    cout << "Do you want to encrypt or decrypt? (e/d): ";
    cin >> mode;
    cin.ignore();

    if (mode == "e") {
        cout << "Enter the plaintext: ";
        getline(cin, text);
        string encryptedText = encryptToMorse(text);
        cout << "Encrypted Morse code: " << encryptedText << endl;
    } else if (mode == "d") {
        cout << "Enter the Morse code (use '/' for space between words): ";
        getline(cin, text);
        string decryptedText = decryptFromMorse(text);
        cout << "Decrypted text: " << decryptedText << endl;
    } else {
        cout << "Invalid option. Please choose 'e' to encrypt or 'd' to decrypt." << endl;
    }

    return 0;
}
