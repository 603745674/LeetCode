public class 整数反转 {
    public static void main(String[] args) {
        System.out.println(reverse(123456));
    }
    public static int reverse(int x) {
        int pop = 0;
        int rev = 0;
        while (x != 0) {
            pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = 10 * rev + pop;
        }
        return rev;
    }
}
