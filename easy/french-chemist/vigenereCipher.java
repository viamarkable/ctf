// not working

import java.util.Scanner;

class VigenereCipher {
    public static String generateKey(String str, String key) {
        int x = str.length();
        for (int i = 0; ; i++) {
            if (x==i) 
                i = 0;
            if (key.length() == str.length()) 
                break;
            key += (key.charAt(i));
        }
        return key;
    }
    public static String encrypt(String plainText, String key) {
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char plainTextChar = plainText.charAt(i);
            char keyChar = key.charAt(i);

            if (Character.isUpperCase(plainTextChar)) {
                int x = (plainTextChar + Character.toUpperCase(keyChar) - 2 * 'A') % 26;
                x += 'A';
                cipherText.append((char) x);
            } else if (Character.isLowerCase(plainTextChar)) {
                int x = (plainTextChar + Character.toUpperCase(keyChar) - 2 * 'a') % 26;
                x += 'a';
                cipherText.append((char) x);
            } else {
                cipherText.append(plainTextChar);
            }
        }
        return cipherText.toString();
    }
    public static String decrypt(String cipherText, String key) {
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char cipherTextChar = plainText.charAt(i);
            char keyChar = key.charAt(i);

            if (Character.isUpperCase(cipherTextChar)) {
                int x = (cipherTextChar - Character.toUpperCase(keyChar) + 26) % 26;
                x += 'A';
                plainText.append((char) x);
            } else if (Character.isLowerCase(cipherTextChar)) {
                int x = (cipherTextChar - Character.toUpperCase(keyChar) + 26) % 26;
                x += 'a';
                plainText.append((char) x);
            } else {
                plainText.append(cipherTextChar);
            }
        }
        return plainText.toString();
    }

    public static void main(String[] args) {
        Scanner question = new Scanner(System.in);
        System.out.println("Do you want to encrypt or decrypt text? (encrypt/decrypt)");

        String function = question.nextLine();

        String plainText = "";
        String cipherText = "";
        String key = "";

        if (function.contains("encrypt")) {
            System.out.println("Enter the plaintext that you would like to encrypt:");
            plainText = question.nextLine();

            System.out.println("Enter the key you would like to use for encryption:");
            key = question.nextLine();

            System.out.println("Encrypting '" + plainText + "'' ...");

            String encryptedText = encrypt(plainText, key);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (function.contains("decrypt")) {
            System.out.println("Enter the ciphertext that you would like to decrypt:");
            cipherText = question.nextLine();

            System.out.println("Enter the key used for encryption:");
            key = question.nextLine();

            System.out.println("Decrypting " + cipherText + " ...");

            String decryptedText = decrypt(cipherText, key);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Error: please re-run and try again");
        }
        question.close();
    }
}



// static String generateKey(String str, String key)
// {
//     int x = str.length();

//     for (int i = 0; ; i++)
//     {
//         if (x == i)
//             i = 0;
//         if (key.length() == str.length())
//             break;
//         key+=(key.charAt(i));
//     }
//     return key;
// }

// static String cipherText(String str, String key)
// {
//     String cipher_text="";

//     for (int i = 0; i < str.length(); i++)
//     {
//         int x = (str.charAt(i) + key.charAt(i)) %26;

//         x += 'A';

//         cipher_text+=(char)(x);
//     }
//     return cipher_text;
// }

// static String originalText(String cipher_text, String key)
// {
//     String orig_text="";

//     for (int i = 0 ; i < cipher_text.length() && 
//                             i < key.length(); i++)
//     {
//         int x = (cipher_text.charAt(i) - 
//                     key.charAt(i) + 26) %26;

//         x += 'A';
//         orig_text+=(char)(x);
//     }
//     return orig_text;
// }
// static String LowerToUpper(String s)
// {
//     StringBuffer str =new StringBuffer(s); 
//     for(int i = 0; i < s.length(); i++)
//     {
//         if(Character.isLowerCase(s.charAt(i)))
//         {
//             str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
//         }
//     }
//     s = str.toString();
//     return s;
// }