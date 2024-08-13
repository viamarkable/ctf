import java.util.Scanner;
import java.util.Arrays;

public class RailFenceCipher {
    public static String encrypt(String plainText, int rowCount) {
        char[][] rail = new char[rowCount][plainText.length()];
        for (int i = 0; i < rowCount; i++) {
            Arrays.fill(rail[i], '\n');
        }

        boolean dirDown = false;
        int row = 0, col = 0;

        for (int i = 0; i < plainText.length(); i++) {
            if (row == 0 || row == rowCount - 1) {
                dirDown = !dirDown;

                rail[row][col++] = plainText.charAt(i);
            }
            if (dirDown) {
                row++;
            } else {
                row--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < plainText.length(); j++) {
                if (rail[i][j] != '\n') {
                    result.append(rail[i][j]);
                }
            }
        }
        return result.toString();
    }
    public static String decrypt(String cipherText, int rowCount) {
        char[][] rail = new char[rowCount][cipherText.length()];
        for (int i = 0; i < rowCount; i++) {
            Arrays.fill(rail[i], '\n');
        }
    
        boolean dirDown = false;
        int row = 0, col = 0;
    
        for (int i = 0; i < cipherText.length(); i++) {
            if (row == 0 || row == rowCount - 1) {
                dirDown = !dirDown;
            }
    
            rail[row][col++] = '*';
    
            if (dirDown) {
                row++;
            } else {
                row--;
            }
        }
    
        int index = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < cipherText.length(); j++) {
                if (rail[i][j] == '*' && index < cipherText.length()) {
                    rail[i][j] = cipherText.charAt(index++);
                }
            }
        }
    
        StringBuilder result = new StringBuilder();
        row = 0;
        col = 0;
        dirDown = false;
    
        for (int i = 0; i < cipherText.length(); i++) {
            if (row == 0 || row == rowCount - 1) {
                dirDown = !dirDown;
            }
    
            result.append(rail[row][col++]);

            if (dirDown) {
                row++;
            } else {
                row--;
            }
        }
    
        return result.toString();
    }

    public static void main(String[] args)
    {
        Scanner question = new Scanner(System.in);
        System.out.println("Do you want to encrypt or decrypt text? (encrypt/decrypt)");

        String function = question.nextLine();
        String plainText = "";
        String cipherText = "";

        int rowCount = 0;

        if (function.contains("encrypt")) {
            System.out.println("Enter the plaintext that you would like to encrypt:");
            plainText = question.nextLine();

            System.out.println("Enter the amount of rows you would like to use for encryption:");
            rowCount = question.nextInt();
            question.nextLine();

            System.out.println("Encrypting '" + plainText + "' ...");

            String encryptedText = encrypt(plainText, rowCount);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (function.contains("decrypt")) {
            System.out.println("Enter the ciphertext that you would like to decrypt:");
            cipherText = question.nextLine();

            System.out.println("Enter the amount of rows used for encryption:");
            rowCount = question.nextInt();
            question.nextLine();

            System.out.println("Decrypting '" + cipherText + "' ...");
            
            String decryptedText = decrypt(cipherText, rowCount);
            System.out.println("Decrypted Text: " + decryptedText);
            // brute force does not work
            // System.out.println("Do you know the amount of rows used for encryption? (y/n)");
            // String aKey = question.nextLine();

            // if (aKey.contains("y")) {
            //     System.out.println("Enter the amount of rows used for encryption:");
            //     rowCount = question.nextInt();
            //     question.nextLine();

            //     System.out.println("Decrypting '" + cipherText + "' ...");

            //     String decryptedText = decrypt(cipherText, rowCount);
            //     System.out.println("Decrypted Text: " + decryptedText);
            // } else {
            //     System.out.println("Decrypting '" + cipherText + "' through brute force...");

            //     for (int i = 1; i <= cipherText.length(); i++) {
            //         String bruteForceResult = decrypt(cipherText, i);
            //         System.out.println("Key " + i + ": " + bruteForceResult);
            //     }
            // }
        } else {
            System.out.println("Error: please re-run and try again");
        }
        question.close();
    }
}
