#include <iostream>
#include <sstream>
#include <iomanip>
#include <string>

using namespace std;

string encodeHex(const string& text) {
    stringstream ss;
    for (char c : text) {
        ss << hex << setw(2) << setfill('0') << (int)c;
    }
    return ss.str();
}

string decodeHex(const string& hexText) {
    stringstream ss(hexText);
    string decoded;
    while (ss.good()) {
        unsigned int value;
        ss >> hex >> value;
        decoded += (char)value;
    }
    return decoded;
}

int main() {
    string mode;
    cout << "Do you want to encode or decode? (e/d): ";
    getline(cin, mode);

    if (mode == "e") {
        string text;
        cout << "Enter the text to encode: ";
        getline(cin, text);
        string encodedText = encodeHex(text);
        cout << "Encoded text: " << encodedText << endl;
    } else if (mode == "d") {
        string hexText;
        cout << "Enter the hexadecimal text to decode: ";
        getline(cin, hexText);
        try {
            string decodedText = decodeHex(hexText);
            cout << "Decoded text: " << decodedText << endl;
        } catch (...) {
            cout << "Invalid hexadecimal input." << endl;
        }
    } else {
        cout << "Invalid option. Please choose 'e' to encode or 'd' to decode." << endl;
    }

    return 0;
}
