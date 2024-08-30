import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCode {
    static HashMap<Character, Character> MORSE_CODE_DICT = new HashMap<Character, Character>(){{
        put('A', ".-");
        put('B', "-...");
        put('C', "-.-.");
        put('D', "-..");
        put('E', ".");
        put('F', "..-.");
        put('G', "--.");
        put('H', "....");
        put('I', "..");
        put('J', ".---");
        put('K', "-.-");
        put('L', ".-..");
        put('M', "--");
        put('N', "-.");
        put('O', "---");
        put('P', ".--.");
        put('Q', "--.-");
        put('R', ".-.");
        put('S', "...");
        put('T', "-");
        put('U', "..-");
        put('V', "...-");
        put('W', ".--");
        put('X', "-..-");
        put('Y', "-.--");
        put('Z', "--..");
        put('1', ".----");
        put('2', "..---");
        put('3', "...--");
        put('4', "....-");
        put('5', ".....");
        put('6', "-....");
        put('7', "--...");
        put('8', "---..");
        put('9', "----.");
        put('0', "-----");
        put(',', "--..--");
        put('.', ".-.-.-");
        put('?', "..--..");
        put('/', "-..-.");
        put('-', "-....-");
        put(')', "-.--.-");
        put(' ', "/");

        for (Map.Entry<Character, String> entry : MORSE_CODE_DICT.entrySet()) {
            MORSE_CODE_REVERSE_DICT.put(entry.getValue(), entry.getKey());
        }
    }
    }

    // private static final Map<Character, String> MORSE_CODE_DICT = new HashMap<>();
    // private static final Map<String, Character> MORSE_CODE_REVERSE_DICT = new HashMap<>();

    public static String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        for (char letter : plaintext.toUpperCase().toCharArray()) {
            String morseCode = MORSE_CODE_DICT.get(letter);
            if (morseCode != null) {
                ciphertext.append(morseCode).append(" ");
            } else {
                ciphertext.append("? ");
            }
        }
        return ciphertext.toString().trim();
    }

    public static String decrypt(String morseCode) {
        StringBuilder plaintext = new StringBuilder();
        String[] words = morseCode.split(" / ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                Character plainChar = MORSE_CODE_REVERSE_DICT.get(letter);
                if (plainChar != null) {
                    plaintext.append(plainChar);
                } else {
                    plaintext.append("?");
                }
            }
            plaintext.append(" ");
        }
        return plaintext.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to encrypt or decrypt? (e/d): ");
        String mode = scanner.nextLine().trim().toLowerCase();

        if (mode.equals("e")) {
            System.out.print("Enter the plaintext: ");
            String text = scanner.nextLine();
            String encryptedText = encrypt(text);
            System.out.println("Encrypted Morse code: " + encryptedText);
        } else if (mode.equals("d")) {
            System.out.print("Enter the Morse code (use '/' for space between words): ");
            String text = scanner.nextLine();
            String decryptedText = decrypt(text);
            System.out.println("Decrypted text: " + decryptedText);
        } else {
            System.out.println("Invalid option. Please choose 'e' to encrypt or 'd' to decrypt.");
        }

        scanner.close();
    }
}