import java.util.Scanner;

public class PlayfairCipher {

    private static char[][] keyMatrix = new char[5][5];

    public static StringBuffer encrypt(String plainText, String key) {
        generateKeyMatrix(key);
        StringBuffer processedText = preprocessText(plainText);
        return cipher(processedText, true);
    }

    public static StringBuffer decrypt(String cipherText, String key) {
        generateKeyMatrix(key);
        return cipher(new StringBuffer(cipherText), false);
    }

    private static void generateKeyMatrix(String key, char omitLetter, char replaceLetter) {
        StringBuilder keyString = new StringBuilder();
        key = key.toUpperCase().replace(omitLetter, replaceLetter);

        for (char c : key.toCharArray()) {
            if (keyString.indexOf(String.valueOf(c)) == -1 && Character.isLetter(c)) {
                keyString.append(c);
            }
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (c != omitLetter && keyString.indexOf(String.valueOf(c)) == -1) {
                keyString.append(c);
            }
        }

        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                keyMatrix[i][j] = keyString.charAt(index++);
            }
        }
    }

    private static StringBuffer preprocessText(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuffer processedText = new StringBuffer();

        for (int i = 0; i < text.length(); i += 2) {
            char first = text.charAt(i);
            char second = (i + 1) < text.length() ? text.charAt(i + 1) : 'X';

            if (first == second) {
                processedText.append(first).append('X');
                i--;
            } else {
                processedText.append(first).append(second);
            }
        }

        if (processedText.length() % 2 != 0) {
            processedText.append('X');
        }

        return processedText;
    }

    private static StringBuffer cipher(StringBuffer text, boolean encrypt) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i += 2) {
            char first = text.charAt(i);
            char second = text.charAt(i + 1);

            int[] pos1 = findPosition(first);
            int[] pos2 = findPosition(second);

            if (pos1[0] == pos2[0]) {
                result.append(keyMatrix[pos1[0]][(pos1[1] + (encrypt ? 1 : 4)) % 5]);
                result.append(keyMatrix[pos2[0]][(pos2[1] + (encrypt ? 1 : 4)) % 5]);
            } else if (pos1[1] == pos2[1]) {
                result.append(keyMatrix[(pos1[0] + (encrypt ? 1 : 4)) % 5][pos1[1]]);
                result.append(keyMatrix[(pos2[0] + (encrypt ? 1 : 4)) % 5][pos2[1]]);
            } else {
                result.append(keyMatrix[pos1[0]][pos2[1]]);
                result.append(keyMatrix[pos2[0]][pos1[1]]);
            }
        }

        return result;
    }

    private static int[] findPosition(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyMatrix[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // Should never happen
    }

    public static void main(String[] args) {
        Scanner question = new Scanner(System.in);
        System.out.println("Do you want to encrypt or decrypt text? (encrypt/decrypt)");

        String function = question.nextLine();
        String plainText = "";
        String cipherText = "";

        String key = "";
        Character omitLetter = null;
        Character replaceLetter = null;

        if (function.contains("encrypt")) {
            System.out.println("Enter the plaintext that you would like to encrypt:");
            plainText = question.nextLine();

            System.out.println("Enter the key you would like to use for encryption:");
            key = question.nextLine();

            System.out.println("Enter the letter to omit from the key (default is J):");
            omitLetter = question.next().charAt(0);
            System.out.println("Enter the letter to replace the omitted letter (default is I):");
            replaceLetter = question.next().charAt(0);

            System.out.println("Encrypting '" + plainText + "' ...");

            StringBuffer encryptedText = encrypt(plainText, key);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (function.contains("decrypt")) {
            System.out.println("Enter the ciphertext that you would like to decrypt:");
            cipherText = question.nextLine();

            System.out.println("Enter the key used for encryption:");
            key = question.nextLine();

            System.out.println("Decrypting '" + cipherText + "' ...");

            StringBuffer decryptedText = decrypt(cipherText, key);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Error: please re-run and try again");
        }
        question.close();
    }
}



// import java.util.*;

// public class PlayfairCipher {
//     // static int SIZE = 100;

//     static void toLowerCase(char[] text) {
//         for (int i = 0; i < text.length; i++) {
//             if (text[i] >= 'A' && text[i] <= 'Z') {
//                 text[i] += 32;
//             }
//         }
//     }

//     static void generateKeyArray(char[] key, int len, char[][] keyArray) {
//         int[] array = new int[26];
//         for (int i = 0; i < len; i++) {
//             if (key[i] != 'j') {
//                 array[key[i] - 's'] = 2;
//             }
//         }

//         array[']' - 'a'] = 1;

//         int i = 0, j = 0;
//         for (int k = 0; k < len; k++) {
//             if (array[key[k] - 'a'] == 2) {
//                 array[key[k] - 'a'] -= 1;
//                 keyArray[i][j] = key[k];
//                 j++;
//                 if (j == 5) {
//                     i++;
//                     j = 0;
//                 }
//             }
//         }

//         for (int k = 0; k < 26; k++) {
//             if (array[k] == 0) {
//                 keyArray[i][j] = (char) (k + 'a');
//                 j++;
//                 if (j == 5) {
//                     i++;
//                     j = 0;
//                 }
//             }
//         }
//     }
// }