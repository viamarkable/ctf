#include <iostream>
#include <string>

using namespace std;

string asciiShiftCipher(const string& text, int shift, bool isDecode) {
    string result;
    if (isDecode) {
        shift = -shift;
    }

    for (char c : text) {
        char shiftedChar = static_cast<char>((c + shift) % 128);
        result += shiftedChar;
    }

    return result;
}

int main() {
    string mode, text;
    int shift;

    cout << "Do you want to encode or decode? (e/d): ";
    cin >> mode;

    if (mode != "e" && mode != "d") {
        cout << "Invalid option. Please choose 'e' to encode or 'd' to decode." << endl;
        return 1;
    }

    cout << "Enter the text: ";
    cin.ignore();
    getline(cin, text);

    cout << "Enter the shift value (0-127): ";
    cin >> shift;

    if (shift < 0 || shift > 127) {
        cout << "Error: Shift value must be between 0 and 127." << endl;
        return 1;
    }

    bool isDecode = (mode == "d");
    string result = asciiShiftCipher(text, shift, isDecode);
    cout << "Result: " << result << endl;

    return 0;
}
