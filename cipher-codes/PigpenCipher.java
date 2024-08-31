import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PigpenCipher {
    private static final Map<Character, String> PIGPEN_CIPHER_KEY = new HashMap<>();
    private static final Map<String, Character> PIGPEN_CIPHER_REVERSE_KEY = new HashMap<>();

    static {
        // values tbd
        PIGPEN_CIPHER_KEY.put('A', "🞀");
        PIGPEN_CIPHER_KEY.put('B', "🞀");
        PIGPEN_CIPHER_KEY.put('C', "🞁");
        PIGPEN_CIPHER_KEY.put('D', "🞂");
        PIGPEN_CIPHER_KEY.put('E', "🞃");
        PIGPEN_CIPHER_KEY.put('F', "🞄");
        PIGPEN_CIPHER_KEY.put('G', "🞅");
        PIGPEN_CIPHER_KEY.put('H', "🞆");
        PIGPEN_CIPHER_KEY.put('I', "🞇");
        PIGPEN_CIPHER_KEY.put('J', "🞈");
        PIGPEN_CIPHER_KEY.put('K', "🞉");
        PIGPEN_CIPHER_KEY.put('L', "🞊");
        PIGPEN_CIPHER_KEY.put('M', "🞋");
        PIGPEN_CIPHER_KEY.put('N', "🞌");
        PIGPEN_CIPHER_KEY.put('O', "🞍");
        PIGPEN_CIPHER_KEY.put('P', "🞎");
        PIGPEN_CIPHER_KEY.put('Q', "🞏");
        PIGPEN_CIPHER_KEY.put('R', "🞐");
        PIGPEN_CIPHER_KEY.put('S', "🞑");
        PIGPEN_CIPHER_KEY.put('T', "🞒");
        PIGPEN_CIPHER_KEY.put('U', "🞓");
        PIGPEN_CIPHER_KEY.put('V', "🞔");
        PIGPEN_CIPHER_KEY.put('W', "🞕");
        PIGPEN_CIPHER_KEY.put('X', "🞖");
        PIGPEN_CIPHER_KEY.put('Y', "🞗");
        PIGPEN_CIPHER_KEY.put('Z', "🞘");

        for (Map.Entry<Character, String> entry : PIGPEN_CIPHER_KEY.entrySet()) {
            PIGPEN_CIPHER_REVERSE_KEY.put(entry.getValue(), entry.getKey());
        }
    }

    public static String encryptPigpen(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        for (char letter : plaintext.toUpperCase().toCharArray()) {
            if (PIGPEN_CIPHER_KEY.containsKey(letter)) {
                ciphertext.append(PIGPEN_CIPHER_KEY.get(letter));
            } else {
                ciphertext.append(letter);
            }
        }
        return ciphertext.toString();
    }

    public static String decryptPigpen(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            String symbol = String.valueOf(ciphertext.charAt(i));
            if (PIGPEN_CIPHER_REVERSE_KEY.containsKey(symbol)) {
                plaintext.append(PIGPEN_CIPHER_REVERSE_KEY.get(symbol));
            } else {
                plaintext.append(symbol);
            }
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to encrypt or decrypt? (e/d): ");
        String mode = scanner.nextLine().trim().toLowerCase();

        if (mode.equals("e")) {
            System.out.print("Enter the plaintext: ");
            String text = scanner.nextLine();
            String encryptedText = encryptPigpen(text);
            System.out.println("Encrypted text: " + encryptedText);
        } else if (mode.equals("d")) {
            System.out.print("Enter the Pigpen cipher text: ");
            String text = scanner.nextLine();
            String decryptedText = decryptPigpen(text);
            System.out.println("Decrypted text: " + decryptedText);
        } else {
            System.out.println("Invalid option. Please choose 'e' to encrypt or 'd' to decrypt.");
        }

        scanner.close();
    }
}
