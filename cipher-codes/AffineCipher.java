import java.util.Scanner;

public class AffineCipher {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return -1;
    }

    public static String affineEncrypt(String text, int a, int b) {
        if (gcd(a, 26) != 1) {
            throw new IllegalArgumentException("a (" + a + ") and 26 are not coprime, encryption is not possible.");
        }

        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char encryptedChar = (char) (((a * (c - base) + b) % 26) + base);
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    public static String affineDecrypt(String ciphertext, int a, int b) {
        int a_inv = modInverse(a, 26);
        if (a_inv == -1) {
            throw new IllegalArgumentException("a (" + a + ") has no modular inverse under 26, decryption is not possible.");
        }

        StringBuilder decrypted = new StringBuilder();
        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char decryptedChar = (char) (((a_inv * (c - base - b + 26)) % 26) + base);
                decrypted.append(decryptedChar);
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to encode or decode? (e/d): ");
        String mode = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();
        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        if (mode.equals("e")) {
            String encryptedText = affineEncrypt(text, a, b);
            System.out.println("Encrypted text: " + encryptedText);
        } else if (mode.equals("d")) {
            String decryptedText = affineDecrypt(text, a, b);
            System.out.println("Decrypted text: " + decryptedText);
        } else {
            System.out.println("Invalid option. Please choose 'e' to encode or 'd' to decode.");
        }

        scanner.close();
    }
}
