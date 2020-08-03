import java.util.HashSet;
import java.util.Set;

//����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
//
// ʾ�� 1:
//
// ����: "abcabcbb"
//���: 3
//����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
//
//
// ʾ�� 2:
//
// ����: "bbbbb"
//���: 1
//����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
//
//
// ʾ�� 3:
//
// ����: "pwwkew"
//���: 3
//����: ��Ϊ���ظ��ַ�����Ӵ���?"wke"�������䳤��Ϊ 3��
//?    ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke"?��һ�������У������Ӵ���
//
// Related Topics ��ϣ�� ˫ָ�� �ַ��� Sliding Window
public class ���ظ��ַ�����ַ��� {
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
