import java.util.Scanner;
import java.util.Arrays;

public class RailFenceCipher {
    public static String encrypt(String plaintext, int rowCount) {
        char[][] rail = new char[rowCount][plaintext.length()];
        for (int i = 0; i < rowCount; i++) {
            Arrays.fill(rail[i], '\n');
        }

        boolean dirDown = false;
        int row = 0, col = 0;

        for (int i = 0; i < plaintext.length(); i++) {
            if (row == 0 || row == rowCount -1) {
                dirDown = !dirDown;

                rail[row][col++] = plaintext.charAt(i);
            }
            if (dirDown) {
                row++;
            } else {
                row--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < plaintext.length(); j++) {
                if (rail[i][j] != '\n') {
                    result.append(rail[i][j]);
                }
            }
        }
        return result.toString();
    }
    public static String decrypt(String ciphertext, int rowCount) {
        char[][] rail = new char[rowCount][ciphertext.length()];
        for (int i = 0; i < rowCount; i++) {
            Arrays.fill(rail[i], '\n');
        }

        boolean dirDown = false;
        int row = 0, col = 0;

        for (int i = 0; i < ciphertext.length(); i++) {
            if (row == 0 || row == rowCount - 1) {
                dirDown = !dirDown;

                rail[row][col++] = '*';
            }

            if (dirDown) {
                row ++;
            } else {
                row--;
            }
        }

        int index = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < ciphertext.length(); j++) {
                if (rail[i][j] == '*' && index < ciphertext.length()) {
                    rail[i][j] = ciphertext.charAt(index++);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        row = 0;
        col = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            if (row == 0 || row == rowCount - 1) {
                dirDown = !dirDown;
            }
            if (rail[row][col] != '*') {
                result.append(rail[row][col++]);
            }
            if (dirDown) {
                row++;
            } else {
                row--;
            }
        }
        return result.toString();
    }
    // driver program to check the above functions
    public static void main(String[] args)
    {
        Scanner question = new Scanner(System.in);
        System.out.println("Do you want to encrypt or decrypt text? (encrypt/decrypt)");

        String function = question.nextLine();
        String plaintext = "";
        String ciphertext = "";

        int rowCount = 0;

        if (function.contains("encrypt")) {
            System.out.println("Enter the plaintext that you would like to encrypt:");
            plaintext = question.nextLine();

            System.out.println("Enter the amount of rows you would like to use for encryption:");
            rowCount = question.nextInt();
            question.nextLine();

            System.out.println("Encrypting " + plaintext + " ...");

            String encryptedText = encrypt(plaintext, rowCount);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (function.contains("decrypt")) {
            System.out.println("Enter the ciphertext that you would like to decrypt:");
            ciphertext = question.nextLine();

            System.out.println("Do you know the amount of rows used for encryption? (y/n)");
            String aKey = question.nextLine();

            if (aKey.contains("y")) {
                System.out.println("Enter the amount of rows used for encryption:");
                rowCount = question.nextInt();
                question.nextLine();

                System.out.println("Decrypting " + ciphertext + " ...");

                String decryptedText = decrypt(plaintext, rowCount);
                System.out.println("Decrypted Text: " + decryptedText);
            } else {
                System.out.println("Decrypting " + ciphertext + " through brute force...");

                for (int i; i < ciphertext.length(); i++) {
                    String bruteForceResult = decrypt(ciphertext, i);
                    System.out.println("Key " + i + ": " + bruteForceResult);
                }
            }
        } else {
            System.out.println("Error: please re-run and try again");
        }
        question.close();
    }
}
