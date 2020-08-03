import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 有效括号 {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        //长度为奇数返回false
        if (chars.length % 2 != 0) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(', 1);
        map.put(')', -1);
        map.put('[', 2);
        map.put(']', -2);
        map.put('{', 3);
        map.put('}', -3);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(map.get(chars[i]));
        }
        remove(list);
        if (list.size() > 0) {
            return false;
        }
        return true;
    }

    public static void remove(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) + list.get(i + 1) == 0) {
                list.remove(i);
                list.remove(i);
                remove(list);
            }
        }
    }
}
