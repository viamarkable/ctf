using System;

public class ROT13Cipher {
    public static StringBuilder encrypt(String plaintext)
    {
        StringBuilder result= new StringBuilder();

        for (int i=0; i<plaintext.Length; i++) {
            if (char.IsUpper(plaintext[i])) {
                char ch = (char)(((int)plaintext[i] + 13 - 65) % 26 + 65);
                result.Append(ch);
            } else {
                char ch = (char)(((int)plaintext[i] + 13 - 97) % 26 + 97);
                result.Append(ch);
            }
        }
        return result;
    }
    public static StringBuilder decrypt(String ciphertext)
    {
        StringBuilder result= new StringBuilder();

        for (int i=0; i<ciphertext.Length; i++) {
            if (char.IsUpper(ciphertext[i])) {
                char ch = (char)(((int)ciphertext[i] - 13 + 26 - 65) % 26 + 65);
                result.Append(ch);
            } else {
                char ch = (char)(((int)ciphertext[i] - 13 + 26 - 97) % 26 + 97);
                result.Append(ch);
            }
        }
        return result;
    }

    public static void Main(String[] args) {
        Console.WriteLine("Do you want to encrypt or decrypt text? (encrypt/decrypt)");
        string question = Console.ReadLine();

        switch(question) {
            case "encrypt";
                Console.WriteLine("Enter the plaintext that you would like to encrypt:");
                string plaintext = Console.ReadLine();

                Console.WriteLine("Encrypting '" + plaintext + "' ...");
                string encryptedText = encrypt(plaintext);

                Console.WriteLine("Encrypted Text: " + encryptedText);
                break;
            case "decrypt";
                Console.WriteLine("Enter the ciphertext that you would like to decrypt:");
                string ciphertext = Console.ReadLine();

                Console.WriteLine("Encrypting '" + ciphertext + "' ...");
                string decryptedText = decrypt(ciphertext);

                Console.WriteLine("Decrypted Text: " + decryptedText);
                break;
        }
    }
}
