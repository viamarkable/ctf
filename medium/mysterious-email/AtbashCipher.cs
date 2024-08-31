using System;
using System.Collections.Generic;

class AtbashCipher {
    static Dictionary<char, char> lookup_table = new Dictionary<char, char>{
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

    static string mirror(string message) {
        string cipher = "";
        foreach(char letter in message) {
            if (letter != ' ') {
                cipher += lookup_table[char.ToUpper(letter)];
            } else {
                cipher += ' ';
            }
        }

        return cipher;
    }

    static void Main() {
        Console.WriteLine("Do you want to encrypt or decrypt text? (encrypt/decrypt)");
        string question = Console.ReadLine();

        switch(question) {
            case "encrypt";
                Console.WriteLine("Enter the plaintext that you would like to encrypt:")
                string plaintext = Console.ReadLine();

                Console.WriteLine("Encrypting '" + plaintext + "' ...");
                string encryptedText = mirror(plaintext);

                Console.WriteLine("Encrypted Text: " + encryptedText);
                break;
            case "decrypt";
                Console.WriteLine("Enter the ciphertext that you would like to decrypt:")
                string ciphertext = Console.ReadLine();

                Console.WriteLine("Decrypting '" + ciphertext + "' ...");
                string decryptedText = mirror(ciphertext);

                Console.WriteLine("Decrypted Text: " + decryptedText);
                break;
        }
    }
}