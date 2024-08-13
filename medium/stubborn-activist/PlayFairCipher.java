import java.util.*;

public class PlayFairCipher {
  static int SIZE = 30;

  static void toLowerCase(char plain[], int ps)
  {
    int i;
    for (i = 0; i < ps; i++) {
      if (plain[i] > 64 && plain[i] < 91)
        plain[i] += 32;
    }
  }

  static int removeSpaces(char[] plain, int ps)
  {
    int i, count = 0;
    for (i = 0; i < ps; i++)
      if (plain[i] != '\u0000')
        plain[count++] = plain[i];

    return count;
  }

  static void generateKeyTable(char key[], int ks, char keyT[][])
  {
    int i, j, k, flag = 0;

    int dicty[] = new int[26];
    for (i = 0; i < ks; i++) {
      if (key[i] != 'j')
        dicty[key[i] - 97] = 2;
    }

    dicty['j' - 97] = 1;

    i = 0;
    j = 0;

    for (k = 0; k < ks; k++) {
      if (dicty[key[k] - 97] == 2) {
        dicty[key[k] - 97] -= 1;
        keyT[i][j] = key[k];
        j++;
        if (j == 5) {
          i++;
          j = 0;
        }
      }
    }

    for (k = 0; k < 26; k++) {
      if (dicty[k] == 0) {
        keyT[i][j] = (char)(k + 97);
        j++;
        if (j == 5) {
          i++;
          j = 0;
        }
      }
    }
  }

  static void search(char keyT[][], char a, char b, int arr[])
  {
    int i, j;

    if (a == 'j')
      a = 'i';
    else if (b == 'j')
      b = 'i';

    for (i = 0; i < 5; i++) {

      for (j = 0; j < 5; j++) {

        if (keyT[i][j] == a) {
          arr[0] = i;
          arr[1] = j;
        }
        else if (keyT[i][j] == b) {
          arr[2] = i;
          arr[3] = j;
        }
      }
    }
  }

  static int mod5(int a) { return (a % 5); }

  static int prepare(char str[], int ptrs)
  {
    if (ptrs % 2 != 0) {
      str[ptrs++] = 'z';
      str[ptrs] = '\0';
    }
    return ptrs;
  }

  