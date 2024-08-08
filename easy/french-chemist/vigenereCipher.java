import java.util.Scanner;

class vigenereCipher {
    public static String generateKey(String str, String key) {
        int x = str.length();
        for (int i = 0; ; i++) {
            if (x==i) i = 0;
            if (key.length() == str.length()) break;
            key += (key.charAt(i));
        }
        return key;
    }
    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char plaintextChar = plaintext.charAt(i);
            char keyChar = key.charAt(i);

            if (Character.isUpperCase(plaintextChar)) {
                int x = (plaintextChar + Character.toUpperCase(keyChar) - 2 * 'A') % 26;
                x += 'A';
                ciphertext.append((char) x);
            } else if (Character.isLowerCase(plaintextChar)) {
                int x = (plaintextChar + Character.toUpperCase(keyChar) - 2 * 'a') % 26;
                x += 'a';
                ciphertext.append((char) x);
            } else {
                ciphertext.append(plaintextChar);
            }
        }
        return ciphertext.toString();
    }
    public static String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char ciphertextChar = plaintext.charAt(i);
            char keyChar = key.charAt(i);

            if (Character.isUpperCase(ciphertextChar)) {
                int x = (ciphertextChar - Character.toUpperCase(keyChar) + 26) % 26;
                x += 'A';
                plaintext.append((char) x);
            } else if (Character.isLowerCase(ciphertextChar)) {
                int x = (ciphertextChar - Character.toUpperCase(keyChar) + 26) % 26;
                x += 'a';
                plaintext.append((char) x);
            } else {
                plaintext.append(ciphertextChar);
            }
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner question = new Scanner(System.in);
        System.out.println("Do you want to encrypt or decrypt text? (encrypt/decrypt)");

        String function = question.nextLine();

        String plaintext = "";
        String ciphertext = "";
        String key = "";

        if (function.contains("encrypt")) {
            System.out.println("Enter the plaintext that you would like to encrypt:");
            plaintext = question.nextLine();

            System.out.println("Enter the key you would like to use for encryption:");
            key = question.nextLine();

            System.out.println("Encrypting " + plaintext + " ...");

            String encryptedText = encrypt(plaintext, key);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (function.contains("decrypt")) {
            System.out.println("Enter the ciphertext that you would like to decrypt:");
            ciphertext = question.nextLine();

            System.out.println("Enter the key used for encryption:");
            key = question.nextLine();

            System.out.println("Decrypting " + ciphertext + " ...");

            String decryptedText = decrypt(ciphertext, key);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Error: please re-run and try again");
        }
        question.close();
    }
}