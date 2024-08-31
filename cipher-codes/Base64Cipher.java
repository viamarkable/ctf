import java.util.Base64;
import java.util.Scanner;

public class Base64Cipher {

    public static String encodeBase64(String message) {
        byte[] messageBytes = message.getBytes();
        byte[] base64Bytes = Base64.getEncoder().encode(messageBytes);
        return new String(base64Bytes);
    }

    public static String decodeBase64(String base64Message) {
        byte[] base64Bytes = base64Message.getBytes();
        byte[] messageBytes = Base64.getDecoder().decode(base64Bytes);
        return new String(messageBytes);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to encode or decode? (e/d): ");
        String mode = scanner.nextLine().trim().toLowerCase();

        if (mode.equals("e")) {
            System.out.print("Enter the message to encode: ");
            String message = scanner.nextLine();
            String encodedMessage = encodeBase64(message);
            System.out.println("Encoded message: " + encodedMessage);
        } else if (mode.equals("d")) {
            System.out.print("Enter the Base64 encoded message to decode: ");
            String base64Message = scanner.nextLine();
            String decodedMessage = decodeBase64(base64Message);
            System.out.println("Decoded message: " + decodedMessage);
        } else {
            System.out.println("Invalid option. Please choose 'e' to encode or 'd' to decode.");
        }

        scanner.close();
    }
}
