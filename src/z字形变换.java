import java.util.ArrayList;
import java.util.List;

public class z×ÖÐÎ±ä»» {
    public static void main(String[] args) {

    }
    public static String convert(String s, int numRows) {
        StringBuffer stringBuffer = new StringBuffer();
        if (numRows < 2) {
            return s;
        }
        int length = s.length();
        int numCols = length % (2 * numRows - 2) == 0 ? (numRows - 1) * (length / (2 * numRows - 2)) : numRows * (length / (2 * numRows - 2)) + length % (2 * numRows - 2);
        Character[][] Char = new Character[numRows][numCols];
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                if (i % (numRows - 1) == 0 && (2 * numRows - 2) * (i / (numRows - 1)) + j < s.length()) {
                    Char[j][i] = s.charAt((2 * numRows - 2) * (i / (numRows - 1)) + j);
                } else if (j + i % (numRows - 1) == numRows - 1 && numRows * ((i / (numRows - 1)) + 1) + i % (numRows - 1) + (numRows - 2) * (i / (numRows - 1)) - 1 < s.length()) {
                    Char[j][i] = s.charAt(numRows * ((i / (numRows - 1)) + 1) + i % (numRows - 1) + (numRows - 2) * (i / (numRows - 1)) - 1);
                } else {
                    Char[j][i] = null;
                }
                System.out.print(Char[j][i]);
            }
            System.out.println();
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (Char[i][j] != null) {
                    stringBuffer.append(Char[i][j]);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String convert1(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> stringBuilder = new ArrayList<>();
        StringBuilder stringBuilder1 = new StringBuilder();
        Integer flag = -1;
        Integer index = 0;
        for (int i = 0; i < numRows; i++) {
            stringBuilder.add(new StringBuilder());
        }
        for (Character c : s.toCharArray()) {
            stringBuilder.get(index).append(c);
            if (index == 0 || index == numRows - 1) {
                flag = -flag;
            }
            index += flag;
        }
        for (StringBuilder str : stringBuilder) {
            stringBuilder1.append(str);
        }
        return stringBuilder1.toString();
    }

}
