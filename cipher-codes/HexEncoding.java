import java.util.Scanner;

public class HexEncoding {

    public static String encodeHex(String text) {
        StringBuilder hexString = new StringBuilder();
        for (char c : text.toCharArray()) {
            hexString.append(String.format("%02x", (int) c));
        }
        return hexString.toString();
    }

    public static String decodeHex(String hexText) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < hexText.length(); i += 2) {
            String str = hexText.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
        return output.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to encode or decode? (e/d): ");
        String mode = scanner.nextLine().trim().toLowerCase();

        if (mode.equals("e")) {
            System.out.print("Enter the text to encode: ");
            String text = scanner.nextLine();
            String encodedText = encodeHex(text);
            System.out.println("Encoded text: " + encodedText);
        } else if (mode.equals("d")) {
            System.out.print("Enter the hexadecimal text to decode: ");
            String hexText = scanner.nextLine();
            try {
                String decodedText = decodeHex(hexText);
                System.out.println("Decoded text: " + decodedText);
            } catch (NumberFormatException e) {
                System.out.println("Invalid hexadecimal input.");
            }
        } else {
            System.out.println("Invalid option. Please choose 'e' to encode or 'd' to decode.");
        }

        scanner.close();
    }
}
