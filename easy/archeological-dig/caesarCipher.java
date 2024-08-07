import java.util.Scanner;

class caesarCipher {
    public static void main(String[] args) {
        Scanner question = new Scanner(System.in);
        System.out.println("Do you want to encrypt text? (y/n)");

        String aEncrypt = question.nextLine();
        String plaintext = "";
        String ciphertext = "";
        
        int key = 0;

        if (aEncrypt.contains("y")) {
            System.out.println("What would you like to encrypt?");
            plaintext = question.nextLine();

            System.out.println("What is your key?");
            key = question.nextInt();
            question.nextLine();

            System.out.println("Encrypting " + plaintext + " ...");

            StringBuffer encryptedText = encrypt(plaintext, key);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (aEncrypt.contains("n")) {
            System.out.println("Do you want to decrypt text? (y/n)");

            String aDecrypt = question.nextLine();

            if (aDecrypt.contains("y")) {
                System.out.println("What would you like to decrypt?");
                ciphertext = question.nextLine();

                System.out.println("Do you know the key? (y/n)");
                String aKey = question.nextLine();

                if (aKey.contains("y")) {
                    System.out.println("What is your key?");
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
                System.out.println("Error: please re-run the program");
            }

        } else {
            System.out.println("Error: please re-run and answer with 'y' or 'n'");
        }
        question.close();
    }

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
}