public class ×Ö·û´®×ª»»ÕûÊý {
    public static void main(String[] args) {
        System.out.println(myAtoi("-+-9999----+++++++ssswwww111233+++++---12832"));
    }
    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for (Character c : chars) {
            if (!flag && !c.equals("")) {
                if ((c.equals("-".charAt(0)) || c.equals("+".charAt(0)) || Character.isDigit(c))) {
                    flag = true;
                    stringBuilder.append(c);
                }
            } else if (c.equals("0") || Character.isDigit(c)) {
                stringBuilder.append(c);
            }
        }
        long i = 0;
        i = Long.parseLong(stringBuilder.toString());
        if (i > Integer.MAX_VALUE) {
            i = Integer.MAX_VALUE;
        }
        if (i < Integer.MIN_VALUE) {
            i = Integer.MIN_VALUE;
        }
        int a = (int) i;
        return a;
    }
}
