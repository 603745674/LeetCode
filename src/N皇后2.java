public class N»Êºó2 {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
    public static int totalNQueens(int n) {
        String[][] strings = new String[n][n];
        Integer result = new Integer(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                strings[i][j] = ".";
            }
        }
        return Backtracking1(result,strings,0,n);
    }
    //»ØËÝ
    public static int Backtracking1(Integer result,String[][] strings, int row, int n){
        if(row == n ){
            return result+1;
        }
        for (int j = 0; j < n; j++) {
            if(check(strings,row,j,n)){
                strings[row][j] = "Q";
                result = Backtracking1(result,strings,row+1,n);
                strings[row][j] = ".";
            }
        }
        return result;
    }
    public static Boolean check(String[][] strings, int row, int col, int n) {
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j < n; j++) {
                if ("Q".equals(strings[i][j]) && (col==j||row==i||Math.abs(row - i) == Math.abs(col - j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
