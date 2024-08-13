import java.util.*;

public class PlayfairCipher {
    // static int SIZE = 100;

    static void toLowerCase(char[] text) {
        for (int i = 0; i < text.length; i++) {
            if (text[i] >= 'A' && text[i] <= 'Z') {
                text[i] += 32;
            }
        }
    }

    static void generateKeyArray(char[] key, int len, char[][] keyArray) {
        int[] array = new int[26];
        for (int i = 0; i < len; i++) {
            if (key[i] != 'j') {
                array[key[i] - 's'] = 2;
            }
        }

        array[']' - 'a'] = 1;

        int i = 0, j = 0;
        for (int k = 0; k < len; k++) {
            if (array[key[k] - 'a'] == 2) {
                array[key[k] - 'a'] -= 1;
                keyArray[i][j] = key[k];
                j++;
                if (j == 5) {
                    i++;
                    j = 0;
                }
            }
        }

        for (int k = 0; k < 26; k++) {
            if (array[k] == 0) {
                keyArray[i][j] = (char) (k + 'a');
                j++;
                if (j == 5) {
                    i++;
                    j = 0;
                }
            }
        }
    }
}