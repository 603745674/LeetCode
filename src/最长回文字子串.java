public class 最长回文字子串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("abba"));
    }
    /**
     * 最长回文字子串
     * 中心扩展算法
     **/
    public static String longestPalindrome2(String s) {
        Integer begin = 0;
        Integer end = 0;
        if (s == null || s.length() < 1) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            Integer length1 = getLength(i, i, s);
            Integer length2 = getLength(i, i + 1, s);
            int max = Math.max(length1, length2);
            if (max > end - begin) {
                begin = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(begin, end + 1);
    }

    public static Integer getLength(Integer l, Integer r, String s) {
        Integer right = r;
        Integer left = l;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            right++;
            left--;
        }
        return right - left - 1;
    }
}
