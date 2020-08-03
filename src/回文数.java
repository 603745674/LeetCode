public class »ØÎÄÊı {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int pos = 0;
        int y = 0;
        while (x > 0) {
            y = x % 10;
            x /= 10;
            pos = 10 * pos + y;
        }
        return temp == pos ? true : false;
    }
}
