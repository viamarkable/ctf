import java.util.*;

class FrequencyAnalysisCipher{

static void printString(String S, int N)
{

	String []plaintext = new String[5];

	int freq[] = new int[26];

	int freqSorted[] = new int[26];

	int Used[] = new int[26];

	for (int i = 0; i < N; i++) {
		if (S.charAt(i) != ' ') {
			freq[S.charAt(i) - 'A']++;
		}
	}

	for (int i = 0; i < 26; i++) {
		freqSorted[i] = freq[i];
	}

	String T = "ETAOINSHRDLCUMWFGYPBVKJXQZ";

	Arrays.sort(freqSorted);
	freqSorted= reverse(freqSorted);
	for (int i = 0; i < 5; i++) {

		int ch = -1;

		for (int j = 0; j < 26; j++) {

			if (freqSorted[i] == freq[j] && Used[j] == 0) {
				Used[j] = 1;
				ch = j;
				break;
			}
		}
		if (ch == -1)
			break;

		int x = T.charAt(i) - 'A';
		
		x = x - ch;

		String curr = "";

		for (int k = 0; k < N; k++) {

			if (S.charAt(k) == ' ') {
				curr += (char)' ';
				continue;
			}

			int y = S.charAt(k) - 'A';
			y += x;

			if (y < 0)
				y += 26;
			if (y > 25)
				y -= 26;

			curr += (char)('A' + y);
		}

		plaintext[i] = curr;
	}

	for (int i = 0; i < 5; i++) {
		System.out.print(plaintext[i] +"\n");
	}
}
static int[] reverse(int a[]) {
	int i, n = a.length, t;
	for (i = 0; i < n / 2; i++) {
		t = a[i];
		a[i] = a[n - i - 1];
		a[n - i - 1] = t;
	}
	return a;
}
public static void main(String[] args)
{
	Scanner question = new Scanner(System.in);
        System.out.println("Do you want to encrypt or decrypt text? (encrypt/decrypt)");

        String function = question.nextLine();

        String plainText = "";
        String cipherText = "";
        String key = "";

        if (function.contains("encrypt")) {
            System.out.println("Enter the plaintext that you would like to encrypt:");
            plainText = question.nextLine();

            System.out.println("Enter the key you would like to use for encryption:");
            key = question.nextLine();

            System.out.println("Encrypting '" + plainText + "'' ...");

            String encryptedText = encrypt(plainText, key);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (function.contains("decrypt")) {
            System.out.println("Enter the ciphertext that you would like to decrypt:");
            cipherText = question.nextLine();

            System.out.println("Enter the key used for encryption:");
            key = question.nextLine();

            System.out.println("Decrypting " + cipherText + " ...");

            String decryptedText = decrypt(cipherText, key);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Error: please re-run and try again");
        }
        question.close();
    
    String S = "B TJNQMF NFTTBHF";
	int N = S.length();

	printString(S, N);

}
}