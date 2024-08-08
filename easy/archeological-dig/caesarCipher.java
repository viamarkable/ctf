import java.util.Scanner;

class CaesarCipher {
    public static StringBuffer encrypt(String plaintext, int s) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < plaintext.length(); i++) {
            if (Character.isUpperCase(plaintext.charAt(i))) {
                char ch = (char) (((int) plaintext.charAt(i) + s - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) plaintext.charAt(i) + s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
    public static StringBuffer decrypt(String ciphertext, int s) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < ciphertext.length(); i++) {
            if (Character.isUpperCase(ciphertext.charAt(i))) {
                char ch = (char) (((int) ciphertext.charAt(i) + s - 65 + 26) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) ciphertext.charAt(i) + s - 97 + 26) % 26 + 97);
                result.append(ch);
            }
        }
        return result; 
    }

    public static void main(String[] args) {
        Scanner question = new Scanner(System.in);
        System.out.println("Do you want to encrypt or decrypt text? (encrypt/decrypt)");

        String function = question.nextLine();
        String plaintext = "";
        String ciphertext = "";
        
        int key = 0;

        if (function.contains("encrypt")) {
            System.out.println("Enter the plaintext that you would like to encrypt:");
            plaintext = question.nextLine();

            System.out.println("Enter the key you would like to use for encryption:");
            key = question.nextInt();
            question.nextLine();

            System.out.println("Encrypting " + plaintext + " ...");

            StringBuffer encryptedText = encrypt(plaintext, key);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (function.contains("decrypt")) {
            System.out.println("Enter the ciphertext that you would like to decrypt:");
            ciphertext = question.nextLine();

            System.out.println("Do you know the key that was used for encryption? (y/n)");
            String aKey = question.nextLine();

            if (aKey.contains("y")) {
                System.out.println("Enter the key used for encryption:");
                key = question.nextInt();
                question.nextLine();

                System.out.println("Decrypting " + ciphertext + " ...");

                StringBuffer decryptedText = decrypt(plaintext, key);
                System.out.println("Decrypted Text: " + decryptedText);
            } else {
                System.out.println("Decrypting " + ciphertext + " through brute force...");

                for (int i = 0; i < 26; i++) {
                    StringBuffer bruteForceResult = decrypt(ciphertext, i);
                    System.out.println("Key " + (i+1) + ": " + bruteForceResult);
                }
            }
        } else {
            System.out.println("Error: please re-run and try again");
        }
        question.close();
    }
}