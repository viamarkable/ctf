import java.util.Scanner;

public class vigenereCipher {
    public static String generateKey(String str, String key) {
        int x = str.length();
        for (int i = 0; ; i++) {
            if (x==i) i = 0l
            if (key.length() == str.length()) break;
            key += (key.charAt(i));
        }
        return key;
    }
    public static StringBuffer encrypt(String plaintext, int i) {
    
    }
    
    public static void main(String[] args) {
        Scanner question = new Scanner(System.in);
        System.out.println("Do you want to encrypt or decrypt text? (encrypt/decrypt)");

        String function = question.nextLine();
        String plaintext = "";
        String ciphertext = "";

        if (function.contains("encrypt")) {
            System.out.println("What is the plaintext that you would like to encrypt?");
            plaintext = question.nextLine();

        } else if (function.contains("decrypt")) {
            System.out.println("What is the ciphertext that you would like to decrypt?");
            ciphertext = question.nextLine();
        }
    }
    
}