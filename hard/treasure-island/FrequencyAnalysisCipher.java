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
