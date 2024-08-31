#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

unordered_map<char, char> createAlbertiWheelMapping(const string& outsideWheel, const string& insideWheel) {
    unordered_map<char, char> mapping;
    for (size_t i = 0; i < outsideWheel.length(); i++) {
        mapping[outsideWheel[i]] = insideWheel[i];
    }
    return mapping;
}

string encryptAlberti(const string& plaintext, const string& outsideWheel, const string& insideWheel) {
    unordered_map<char, char> mapping = createAlbertiWheelMapping(outsideWheel, insideWheel);
    string ciphertext;
    for (char c : plaintext) {
        char upperC = toupper(c);
        if (mapping.find(upperC) != mapping.end()) {
            ciphertext += mapping[upperC];
        } else {
            ciphertext += c;
        }
    }
    return ciphertext;
}

string decryptAlberti(const string& ciphertext, const string& outsideWheel, const string& insideWheel) {
    unordered_map<char, char> reverseMapping = createAlbertiWheelMapping(insideWheel, outsideWheel);
    string plaintext;
    for (char c : ciphertext) {
        if (reverseMapping.find(c) != reverseMapping.end()) {
            plaintext += reverseMapping[c];
        } else {
            plaintext += c;
        }
    }
    return plaintext;
}

int main() {
    string outsideWheel, insideWheel, mode, text;

    cout << "Enter the characters of the outside wheel: ";
    getline(cin, outsideWheel);
    for (char& c : outsideWheel) c = toupper(c);

    cout << "Enter the characters of the inside wheel: ";
    getline(cin, insideWheel);
    for (char& c : insideWheel) c = toupper(c);

    if (outsideWheel.length() != insideWheel.length()) {
        cout << "Error: The outside and inside wheels must have the same length." << endl;
        return 1;
    }

    cout << "Do you want to encrypt or decrypt? (e/d): ";
    getline(cin, mode);

    if (mode == "e") {
        cout << "Enter the plaintext message: ";
        getline(cin, text);
        string encryptedText = encryptAlberti(text, outsideWheel, insideWheel);
        cout << "Encrypted message: " << encryptedText << endl;
    } else if (mode == "d") {
        cout << "Enter the encrypted message: ";
        getline(cin, text);
        string decryptedText = decryptAlberti(text, outsideWheel, insideWheel);
        cout << "Decrypted message: " << decryptedText << endl;
    } else {
        cout << "Invalid option. Please choose 'e' to encrypt or 'd' to decrypt." << endl;
    }

    return 0;
}