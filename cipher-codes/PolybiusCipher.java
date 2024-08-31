import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PolybiusCipher {

    public static Map<Character, String> createPolybiusGrid(String key) {
        Map<Character, String> grid = new HashMap<>();
        int index = 0;
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= 5; col++) {
                if (index < key.length()) {
                    grid.put(key.charAt(index), String.valueOf(row) + col);
                    index++;
                }
            }
        }
        return grid;
    }

    public static Map<String, Character> reversePolybiusGrid(Map<Character, String> grid) {
        Map<String, Character> reverseGrid = new HashMap<>();
        for (Map.Entry<Character, String> entry : grid.entrySet()) {
            reverseGrid.put(entry.getValue(), entry.getKey());
        }
        return reverseGrid;
    }

    public static String encryptPolybius(String plaintext, Map<Character, String> grid) {
        StringBuilder ciphertext = new StringBuilder();
        for (char c : plaintext.toUpperCase().toCharArray()) {
            if (grid.containsKey(c)) {
                ciphertext.append(grid.get(c));
            } else {
                ciphertext.append(c);
            }
        }
        return ciphertext.toString();
    }

    public static String decryptPolybius(String ciphertext, Map<String, Character> reverseGrid) {
        StringBuilder plaintext = new StringBuilder();
        int i = 0;
        while (i < ciphertext.length()) {
            if (i + 1 < ciphertext.length() && Character.isDigit(ciphertext.charAt(i)) && Character.isDigit(ciphertext.charAt(i + 1))) {
                String key = "" + ciphertext.charAt(i) + ciphertext.charAt(i + 1);
                plaintext.append(reverseGrid.getOrDefault(key, ' '));
                i += 2;
            } else {
                plaintext.append(ciphertext.charAt(i));
                i++;
            }
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the characters of the Polybius grid (25 unique characters): ");
        String key = scanner.nextLine().toUpperCase();

        if (key.length() != 25 || key.chars().distinct().count() != 25) {
            System.out.println("Error: The key must contain 25 unique characters.");
            scanner.close();
            return;
        }

        Map<Character, String> polybiusGrid = createPolybiusGrid(key);
        Map<String, Character> reverseGrid = reversePolybiusGrid(polybiusGrid);

        System.out.print("Do you want to encrypt or decrypt? (e/d): ");
        String mode = scanner.nextLine().trim().toLowerCase();

        if (mode.equals("e")) {
            System.out.print("Enter the plaintext message: ");
            String plaintext = scanner.nextLine();
            String encryptedMessage = encryptPolybius(plaintext, polybiusGrid);
            System.out.println("Encrypted message: " + encryptedMessage);
        } else if (mode.equals("d")) {
            System.out.print("Enter the ciphertext message: ");
            String ciphertext = scanner.nextLine();
            String decryptedMessage = decryptPolybius(ciphertext, reverseGrid);
            System.out.println("Decrypted message: " + decryptedMessage);
        } else {
            System.out.println("Invalid option. Please choose 'e' to encrypt or 'd' to decrypt.");
        }

        scanner.close();
    }
}
