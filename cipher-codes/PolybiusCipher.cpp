#include <iostream>
#include <unordered_map>
#include <string>
#include <cctype>

using namespace std;

unordered_map<char, string> createPolybiusGrid(const string& key) {
    unordered_map<char, string> grid;
    int index = 0;
    for (int row = 1; row <= 5; ++row) {
        for (int col = 1; col <= 5; ++col) {
            if (index < key.length()) {
                grid[key[index]] = to_string(row) + to_string(col);
                ++index;
            }
        }
    }
    return grid;
}

unordered_map<string, char> reversePolybiusGrid(const unordered_map<char, string>& grid) {
    unordered_map<string, char> reverseGrid;
    for (const auto& entry : grid) {
        reverseGrid[entry.second] = entry.first;
    }
    return reverseGrid;
}

string encryptPolybius(const string& plaintext, const unordered_map<char, string>& grid) {
    string ciphertext;
    for (char c : plaintext) {
        char upperC = toupper(c);
        if (grid.find(upperC) != grid.end()) {
            ciphertext += grid.at(upperC);
        } else {
            ciphertext += c;
        }
    }
    return ciphertext;
}

string decryptPolybius(const string& ciphertext, const unordered_map<string, char>& reverseGrid) {
    string plaintext;
    size_t i = 0;
    while (i < ciphertext.length()) {
        if (isdigit(ciphertext[i]) && (i + 1) < ciphertext.length() && isdigit(ciphertext[i + 1])) {
            string key = string(1, ciphertext[i]) + ciphertext[i + 1];
            plaintext += reverseGrid.at(key);
            i += 2;
        } else {
            plaintext += ciphertext[i];
            ++i;
        }
    }
    return plaintext;
}

int main() {
    string key, mode, text;

    cout << "Enter the characters of the Polybius grid (25 unique characters): ";
    getline(cin, key);
    for (char& c : key) c = toupper(c);

    if (key.length() != 25 || unordered_map<char>(key.begin(), key.end()).size() != 25) {
        cout << "Error: The key must contain 25 unique characters." << endl;
        return 1;
    }

    unordered_map<char, string> polybiusGrid = createPolybiusGrid(key);
    unordered_map<string, char> reverseGrid = reversePolybiusGrid(polybiusGrid);

    cout << "Do you want to encrypt or decrypt? (e/d): ";
    getline(cin, mode);

    if (mode == "e") {
        cout << "Enter the plaintext message: ";
        getline(cin, text);
        string encryptedMessage = encryptPolybius(text, polybiusGrid);
        cout << "Encrypted message: " << encryptedMessage << endl;
    } else if (mode == "d") {
        cout << "Enter the ciphertext message: ";
        getline(cin, text);
        string decryptedMessage = decryptPolybius(text, reverseGrid);
        cout << "Decrypted message: " << decryptedMessage << endl;
    } else {
        cout << "Invalid option. Please choose 'e' to encrypt or 'd' to decrypt." << endl;
    }

    return 0;
}
