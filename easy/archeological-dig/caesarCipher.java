import java.util.Scanner;

class CaesarCipher {
    public static StringBuffer encrypt(String plainText, int s) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < plainText.length(); i++) {
            if (Character.isUpperCase(plainText.charAt(i))) {
                char ch = (char) (((int) plainText.charAt(i) + s - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) plainText.charAt(i) + s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
    public static StringBuffer decrypt(String cipherText, int s) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < cipherText.length(); i++) {
            if (Character.isUpperCase(cipherText.charAt(i))) {
                char ch = (char) (((int) cipherText.charAt(i) + s - 65 + 26) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) cipherText.charAt(i) + s - 97 + 26) % 26 + 97);
                result.append(ch);
            }
        }
        return result; 
    }

    public static void main(String[] args) {
        Scanner question = new Scanner(System.in);
        System.out.println("Do you want to encrypt or decrypt text? (encrypt/decrypt)");

        String function = question.nextLine();
        String plainText = "";
        String cipherText = "";
        
        int key = 1;

        if (function.contains("encrypt")) {
            System.out.println("Enter the plaintext that you would like to encrypt:");
            plainText = question.nextLine();

            System.out.println("Enter the key you would like to use for encryption:");
            key = question.nextInt();
            question.nextLine();

            System.out.println("Encrypting '" + plainText + "' ...");

            StringBuffer encryptedText = encrypt(plainText, key);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (function.contains("decrypt")) {
            System.out.println("Enter the ciphertext that you would like to decrypt:");
            cipherText = question.nextLine();

            System.out.println("Do you know the key that was used for encryption? (y/n)");
            String aKey = question.nextLine();

            if (aKey.contains("y")) {
                System.out.println("Enter the key used for encryption:");
                key = question.nextInt();
                question.nextLine();

                System.out.println("Decrypting '" + cipherText + "' ...");

                StringBuffer decryptedText = decrypt(cipherText, key);
                System.out.println("Decrypted Text: " + decryptedText);
            } else {
                System.out.println("Decrypting '" + cipherText + "'' through brute force...");

                for (int i = 0; i < 26; i++) {
                    StringBuffer bruteForceResult = decrypt(cipherText, i);
                    System.out.println("Key " + (i+1) + ": " + bruteForceResult);
                }
            }
        } else {
            System.out.println("Error: please re-run and try again");
        }
        question.close();
    }
}