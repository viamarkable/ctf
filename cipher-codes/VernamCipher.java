import java.util.Scanner;

public class VernamCipher {
    public static String encrypt(String plaintext, String key) {
        if (plaintext.length() != key.length()) {
            throw new IllegalArgumentException("The length of the key must be equal to the length of the plaintext.");
        }

        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char p = plaintext.charAt(i);
            char k = key.charAt(i);
            char cipherChar = (char) (p ^ k);
            ciphertext.append(cipherChar);
        }

        return ciphertext.toString();
    }
    public static String decrypt(String ciphertext, String key) {
        if (ciphertext.length() != key.length()) {
            throw new IllegalArgumentException("The length of the key must be equal to the length of the ciphertext.");
        }

        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            char k = key.charAt(i);
            char plainChar = (char) (c ^ k);
            plaintext.append(plainChar);
        }

        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to encrypt or decrypt? (e/d): ");
        String mode = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter the plaintext or ciphertext: ");
        String text = scanner.nextLine();

        System.out.print("Enter the key: ");
        String key = scanner.nextLine();

        if (mode.equals("e")) {
            String encryptedText = encrypt(text, key);
            System.out.println("Encrypted text: " + encryptedText);
        } else if (mode.equals("d")) {
            String decryptedText = decrypt(text, key);
            System.out.println("Decrypted text: " + decryptedText);
        } else {
            System.out.println("Invalid option. Please choose 'e' to encrypt or 'd' to decrypt.");
        }

        scanner.close();
    }
}