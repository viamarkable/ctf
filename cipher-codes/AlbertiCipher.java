import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AlbertiCipher {

    public static Map<Character, Character> createAlbertiWheelMapping(String outsideWheel, String insideWheel) {
        Map<Character, Character> mapping = new HashMap<>();
        for (int i = 0; i < outsideWheel.length(); i++) {
            mapping.put(outsideWheel.charAt(i), insideWheel.charAt(i));
        }
        return mapping;
    }

    public static String encryptAlberti(String plaintext, String outsideWheel, String insideWheel) {
        Map<Character, Character> mapping = createAlbertiWheelMapping(outsideWheel, insideWheel);
        StringBuilder ciphertext = new StringBuilder();
        for (char c : plaintext.toUpperCase().toCharArray()) {
            ciphertext.append(mapping.getOrDefault(c, c));
        }
        return ciphertext.toString();
    }

    public static String decryptAlberti(String ciphertext, String outsideWheel, String insideWheel) {
        Map<Character, Character> reverseMapping = createAlbertiWheelMapping(insideWheel, outsideWheel);
        StringBuilder plaintext = new StringBuilder();
        for (char c : ciphertext.toCharArray()) {
            plaintext.append(reverseMapping.getOrDefault(c, c));
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the characters of the outside wheel: ");
        String outsideWheel = scanner.nextLine().toUpperCase();

        System.out.print("Enter the characters of the inside wheel: ");
        String insideWheel = scanner.nextLine().toUpperCase();

        // need to fix logic here
        if (outsideWheel.length() != insideWheel.length()) {
            System.out.println("Error: The outside and inside wheels must have the same length.");
            return;
        }

        System.out.print("Do you want to encrypt or decrypt? (e/d): ");
        String mode = scanner.nextLine().trim().toLowerCase();

        if (mode.equals("e")) {
            System.out.print("Enter the plaintext message: ");
            String plaintext = scanner.nextLine();
            String encryptedText = encryptAlberti(plaintext, outsideWheel, insideWheel);
            System.out.println("Encrypted message: " + encryptedText);
        } else if (mode.equals("d")) {
            System.out.print("Enter the encrypted message: ");
            String ciphertext = scanner.nextLine();
            String decryptedText = decryptAlberti(ciphertext, outsideWheel, insideWheel);
            System.out.println("Decrypted message: " + decryptedText);
        } else {
            System.out.println("Invalid option. Please choose 'e' to encrypt or 'd' to decrypt.");
        }

        scanner.close();
    }
}
