import java.util.HashMap;
import java.util.Map;

public class ColumnarTranspositionCipher {
    static final String key = "HACK";
    static Map<Character, Integer> keyMap = new HashMap<>();

    static void setPermutationOrder() {
        for (int i = 0; i < key.length(); i++) {
            keyMap.put(key.charAt(i), i);
        }
    }

    public static String encryptMessage(String msg) {
        int row, col;
        StringBuilder cipher = new StringBuilder();

        col = key.length();

        row = (int) Math.ceil((double) msg.length() / col);

        char[][] matrix = new char[row][col];

        for (int i = 0, k = 0; i < row; i++) {
            for (int j = 0; j < col; ) {
                if (k < msg.length()) {
                    char ch = msg.charAt(k);
                    if (Character.isLetter(ch) || ch == ' ') {
                        matrix[i][j] = ch;
                        j++;
                    }
                    k++;
                } else {
                    matrix[i][j] = '_';
                    j++;
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : keyMap.entrySet()) {
            int columnIndex = entry.getValue();

            for (int i = 0; i < row; i++) {
                if (Character.isLetter(matrix[i][columnIndex]) || matrix[i][columnIndex] == ' ' || matrix[i][columnIndex] == '_') {
                    cipher.append(matrix[i][columnIndex]);
                }
            }
        }

        return cipher.toString();
    }

    
}
