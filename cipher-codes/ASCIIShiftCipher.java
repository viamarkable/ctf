import java.util.Scanner;

public class ASCIIShiftCipher {

    public static String asciiShiftCipher(String text, int shift, boolean isDecode) {
        StringBuilder result = new StringBuilder();
        if (isDecode) {
            shift = -shift;
        }

        for (char c : text.toCharArray()) {
            char shiftedChar = (char) ((c + shift) % 128);
            result.append(shiftedChar);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to encode or decode? (e/d): ");
        String mode = scanner.nextLine().trim().toLowerCase();

        if (!mode.equals("e") && !mode.equals("d")) {
            System.out.println("Invalid option. Please choose 'e' to encode or 'd' to decode.");
            scanner.close();
            return;
        }

        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        System.out.print("Enter the shift value (0-127): ");
        int shift = scanner.nextInt();

        if (shift < 0 || shift > 127) {
            System.out.println("Error: Shift value must be between 0 and 127.");
            scanner.close();
            return;
        }

        boolean isDecode = mode.equals("d");
        String result = asciiShiftCipher(text, shift, isDecode);
        System.out.println("Result: " + result);

        scanner.close();
    }
}
