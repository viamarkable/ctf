using System;

public class CaesarCipher {
    public static StringBuilder encrypt(String plaintext, int s)
    {
        StringBuilder result= new StringBuilder();

        for (int i=0; i<plaintext.Length; i++) {
            if (char.IsUpper(plaintext[i])) {
                char ch = (char)(((int)plaintext[i] + s - 65) % 26 + 65);
                result.Append(ch);
            } else {
                char ch = (char)(((int)plaintext[i] + s - 97) % 26 + 97);
                result.Append(ch);
            }
        }
        return result;
    }
    public static StringBuilder decrypt(String ciphertext, int s)
    {
        StringBuilder result= new StringBuilder();

        for (int i=0; i<ciphertext.Length; i++) {
            if (char.IsUpper(ciphertext[i])) {
                char ch = (char)(((int)ciphertext[i] - s + 26 - 65) % 26 + 65);
                result.Append(ch);
            } else {
                char ch = (char)(((int)ciphertext[i] - s + 26 - 97) % 26 + 97);
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

                Console.WriteLine("Enter the shift you would like to use for encryption:");
                int key = Console.ReadLine();

                Console.WriteLine("Encrypting '" + plaintext + "' ...");
                string encryptedText = encrypt(plaintext, key);

                Console.WriteLine("Encrypted Text: " + encryptedText);
                break;
            case "decrypt";
                Console.WriteLine("Enter the ciphertext that you would like to decrypt:");
                string ciphertext = Console.ReadLine();

                Console.WriteLine("Do you know the shift used for encryption? (y/n)");
                string aKey = Console.ReadLine();

                switch(aKey) {
                    case "y";
                        Console.WriteLine("Enter the shift used for encryption:");
                        int key = Console.ReadLine();

                        Console.WriteLine("Decrypting '" + ciphertext + "' ...");
                        string decryptedText = decrypt(ciphertext, key);

                        Console.WriteLine("Decrypted Text: " + decryptedText);
                        break;
                    case "n";
                        Console.WriteLine("Decrypting '" + ciphertext + "' through brute force...");
                        
                        for (int i = 0; i < 26; i++) {
                            string bruteForceResult = decrypt(ciphertext, i);
                            Console.WriteLine("Shift of " + i + ": " + bruteForceResult);
                        }
                        break;
                }
        }
    }
}
