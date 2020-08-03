import java.util.HashMap;

public class 罗马数字转整数 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
        int temp = 0;
        int a = 0;
        int result = 0;
        HashMap<Character, Integer> stringHashMap = new HashMap<Character, Integer>();
        stringHashMap.put('I', 1);
        stringHashMap.put('V', 5);
        stringHashMap.put('X', 10);
        stringHashMap.put('L', 50);
        stringHashMap.put('C', 100);
        stringHashMap.put('D', 500);
        stringHashMap.put('M', 1000);
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            temp = stringHashMap.get(chars[i]);
            if (temp >= a) {
                result += temp;
            } else {
                result -= temp;
            }
            a = temp;
        }

        return result;
    }
}
