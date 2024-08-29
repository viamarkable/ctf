import java.util.*;

class FrequencyAnalysisCipher{
    public static void printString(String cipherText, int textLength) {

	    String[] plaintext = new String[26];
    	int freq[] = new int[26];
    	int freqSorted[] = new int[26];
    	int Used[] = new int[26];
        
        for (int i = 0; i < textLength; i++) {
            if (cipherText.charAt(i) != ' ') {
                freq[Character.toUpperCase(cipherText.charAt(i)) - 'A']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            freqSorted[i] = freq[i];
        }

        String T = "ETAOINSHRDLCUMWFGYPBVKJXQZ";

        Arrays.sort(freqSorted);
        freqSorted= reverse(freqSorted);

        char[] mappings = new char[26];

        for (int i = 0; i < 26; i++) {
            int ch = -1;

            for (int j = 0; j < 26; j++) {

                if (freqSorted[i] == freq[j] && Used[j] == 0) {
                    Used[j] = 1;
                    ch = j;
                    mappings[ch] = T.charAt(i);
                    break;
                }
            }
            if (ch == -1)
                break;
            
            int x = T.charAt(i) - 'A';
            x = x - ch;

            String curr = "";

            for (int k = 0; k < textLength; k++) {

                if (cipherText.charAt(k) == ' ') {
                    curr += (char)' ';
                    continue;
                }

                int y = cipherText.charAt(k) - 'A';
                y += x;

                if (y < 0)
                    y += 26;
                if (y > 25)
                    y -= 26;

                curr += (char)('A' + y);
            }

		plaintext[i] = curr;
	}
    
    System.out.println("\nLetter mappings based on frequency analysis:");
        for (int i = 0; i < 26; i++) {
            if (mappings[i] != 0) {
                System.out.println((char) ('A' + i) + " -> " + mappings[i]);
            }
        }

        System.out.println("\nPossible plaintexts:");
        for (int i = 0; i < 26; i++) {
            System.out.print(plaintext[i] + "\n");
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
static void printFrequencies(int[] freq) {
    List<Map.Entry<Character, Integer>> freqList = new ArrayList<>();

    for (int i = 0; i < 26; i++) {
        if (freq[i] > 0) {
            freqList.add(new AbstractMap.SimpleEntry<>((char) ('A' + i), freq[i]));
        }
    }

    freqList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

    System.out.println("Frequencies of letters in the ciphertext (from highest to lowest):");
    for (Map.Entry<Character, Integer> entry : freqList) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}

public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
        System.out.println("Enter the ciphertext to perform frequency analysis on: ");
        String ciphertext = input.nextLine();

        System.out.println("Performing frequency analysis on '" + ciphertext + "' ...");

        printString(ciphertext, ciphertext.length());

        input.close();
}
}