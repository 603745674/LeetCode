public class 最长公共前缀 {
    public static void main(String[] args) {
        String[] strings = new String[]{"123","123123123","121212"};
        System.out.println(longestCommonPrefix(strings));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = "";
        String temp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < temp.length()) {
                temp = strs[i];
            }
        }
        if (temp.length() == 0) {
            return "";
        }
        for (int i = 1; i <= temp.length(); i++)
            for (String s : strs) {
                result = temp.substring(0, i);
                if (!s.startsWith(result)) {
                    return temp.substring(0, i - 1);
                }
            }
        return result;
    }
}
