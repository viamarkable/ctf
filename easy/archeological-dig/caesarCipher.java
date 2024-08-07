import java.util.Scanner;

class caesarCipher {
    // Scanner reader = new Scanner(System.in);
    // System.out.println("Would you like to encode a message? (y/n)");
    // int n = reader.nextInt();
    // reader.close();

    public static void main(String[] args) {
        Scanner question = new Scanner(System.in);
        System.out.println("Do you want to encrypt text? (y/n)");

        String answer = question.nextLine();

        if (answer.contains("y")) {
            Scanner plaintext = new Scanner(System.in);
            System.out.println("What would you like to encrypt?");

            String text = plaintext.nextLine();

        } else if (answer.contains("n")) {

        } else {
            System.out.println("Error: please re-run and answer with 'y' or 'n'");
        }
        question.close();
    }

    public static StringBuffer encrypt(String plaintext, int s) {
        StringBuffer result = new StringBuffer();

        for (int i=0; i<plaintext.length(); i++) {
            if (Character.isUpperCase(plaintext.charAt(i))) {
                // char ch = (char)(((int)plaintext.charAt(i))) + 

            }
            
        }
        return result;
    }
}
