import java.util.*;

public class AtbashCipher {
    static HashMap<Character, Character> lookup_table = new HashMap<Character, Character>(){{
        put('A', 'Z'); 
        put('B', 'Y'); 
        put('C', 'X'); 
        put('D', 'W'); 
        put('E', 'V'); 
        put('F', 'U');
        put('G', 'T'); 
        put('H', 'S'); 
        put('I', 'R'); 
        put('J', 'Q'); 
        put('K', 'P'); 
        put('L', 'O');
        put('M', 'N'); 
        put('N', 'M'); 
        put('O', 'L'); 
        put('P', 'K'); 
        put('Q', 'J'); 
        put('R', 'I');
        put('S', 'H'); 
        put('T', 'G'); 
        put('U', 'F'); 
        put('V', 'E'); 
        put('W', 'D'); 
        put('X', 'C');
        put('Y', 'B'); 
        put('Z', 'A');
    }};

    public static String mirror(String message)
    {
        String cipher = "";
        for(char letter : message.toCharArray())
        {
            if(letter != ' ')
            {
                cipher += Character.toLowerCase(lookup_table.get(Character.toUpperCase(letter)));
            }
            else
            {
                cipher += ' ';
            }
        }
        return cipher;
    }

    public static void main(String[] args) {
        Scanner question = new Scanner(System.in);
        System.out.println("Do you want to encrypt or decrypt text? (encrypt/decrypt)");

        String function = question.nextLine();
        String plainText = "";
        String cipherText = "";

        if (function.contains("encrypt")) {
            System.out.println("Enter the plaintext that you would like to encrypt:");
            plainText = question.nextLine();

            System.out.println("Encrypting '" + plainText + "' ...");

            String encryptedText = mirror(plainText);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (function.contains("decrypt")) {
            System.out.println("Enter the ciphertext that you would like to decrypt:");
            cipherText = question.nextLine();

            System.out.println("Encrypting '" + cipherText + "' ...");

            String decryptedText = mirror(cipherText);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Error: please re-run and try again");
        }
        question.close();
    }
}
