import java.util.Scanner;

class ROT13Cipher {
    public static StringBuffer encrypt(String plainText) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < plainText.length(); i++) {
            if (Character.isUpperCase(plainText.charAt(i))) {
                char ch = (char) (((int) plainText.charAt(i) + 13 - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) plainText.charAt(i) + 13 - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
    public static StringBuffer decrypt(String cipherText) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < cipherText.length(); i++) {
            if (Character.isUpperCase(cipherText.charAt(i))) {
                char ch = (char) (((int) cipherText.charAt(i) + 13 - 65 + 26) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) cipherText.charAt(i) + 13 - 97 + 26) % 26 + 97);
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

        if (function.contains("encrypt")) {
            System.out.println("Enter the plaintext that you would like to encrypt:");
            plainText = question.nextLine();

            System.out.println("Encrypting '" + plainText + "' ...");

            StringBuffer encryptedText = encrypt(plainText);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (function.contains("decrypt")) {
            System.out.println("Enter the ciphertext that you would like to decrypt:");
            cipherText = question.nextLine();

            System.out.println("Encrypting '" + cipherText + "' ...");

            StringBuffer decryptedText = encrypt(cipherText);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Error: please re-run and try again");
        }
        question.close();
    }
}