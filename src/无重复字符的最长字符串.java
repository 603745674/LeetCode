import java.util.HashSet;
import java.util.Set;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是?"wke"，所以其长度为 3。
//?    请注意，你的答案必须是 子串 的长度，"pwke"?是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
public class 无重复字符的最长字符串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdfefef"));
    }
    public static  int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if(chars.length==1){
            return 1;
        }
        Integer length = 0;
        Set<Character> map = new HashSet<>();
        for (int i = 0; i <chars.length; i++) {
            if (map.contains(chars[i]) && length < map.size()) {
                length = map.size();
                map.clear();
                map.add(chars[i-1]);
                map.add(chars[i]);
            }else {
                map.add(chars[i]);
            }
            if(i==chars.length-1&&length < map.size()){
                length = map.size();
            }
        }
        return length;
    }

}
