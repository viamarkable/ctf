import java.util.Scanner;

public class PlayfairCipher {

    private static char[][] keyMatrix = new char[5][5];
    private static String key = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get operation from user
        System.out.println("Playfair Cipher 🧑‍💻");
        System.out.println("Type 'encrypt' to Encrypt or 'decrypt' to Decrypt:");
        String operation = scanner.nextLine().trim().toLowerCase();

        // Get key and text from user
        System.out.print("Enter the key: ");
        key = scanner.nextLine().toUpperCase();
        System.out.print("Enter the text: ");
        String text = scanner.nextLine().toUpperCase();

        scanner.close();
        // Generate the key matrix
        generateKeyMatrix(key);

        // Perform the chosen operation
        String result;
        if ("encrypt".equals(operation)) {
            result = encrypt(text);
        } else if ("decrypt".equals(operation)) {
            result = decrypt(text);
        } else {
            System.out.println("Invalid operation.");
            return;
        }
        // Display the result
        System.out.println("Result: " + result);
    }

    private static void generateKeyMatrix(String key) {
        StringBuilder keyString = new StringBuilder();

        // Remove duplicates from key and append the remaining alphabet
        for (char c : key.toCharArray()) {
            if (c != 'J' && keyString.indexOf(String.valueOf(c)) == -1) {
                keyString.append(c);
            }
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (c != 'J' && keyString.indexOf(String.valueOf(c)) == -1) {
                keyString.append(c);
            }
        }

        // Fill the key matrix
        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                keyMatrix[i][j] = keyString.charAt(index++);
            }
        }
    }

    private static String preprocessText(String text) {
        text = text.replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder processedText = new StringBuilder();

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

        return processedText.toString();
    }

    private static String encrypt(String plaintext) {
        plaintext = preprocessText(plaintext);
        return cipher(plaintext, true);
    }

    private static String decrypt(String ciphertext) {
        return cipher(ciphertext, false);
    }

    private static String cipher(String text, boolean encrypt) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            char first = text.charAt(i);
            char second = text.charAt(i + 1);

            int[] pos1 = findPosition(first);
            int[] pos2 = findPosition(second);

            if (pos1[0] == pos2[0]) {
                // Same row
                result.append(keyMatrix[pos1[0]][(pos1[1] + (encrypt ? 1 : 4)) % 5]);
                result.append(keyMatrix[pos2[0]][(pos2[1] + (encrypt ? 1 : 4)) % 5]);
            } else if (pos1[1] == pos2[1]) {
                // Same column
                result.append(keyMatrix[(pos1[0] + (encrypt ? 1 : 4)) % 5][pos1[1]]);
                result.append(keyMatrix[(pos2[0] + (encrypt ? 1 : 4)) % 5][pos2[1]]);
            } else {
                // Rectangle swap
                result.append(keyMatrix[pos1[0]][pos2[1]]);
                result.append(keyMatrix[pos2[0]][pos1[1]]);
            }
        }

        return result.toString();
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