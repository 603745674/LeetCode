import java.util.ArrayList;
import java.util.List;

public class N皇后 {
    public static void main(String[] args) {
        solveNQueens(4);
    }
    public static List<List<String>> solveNQueens(int n) {
       /*   public void backTracing(char[][] chs,int row,int n,List<List<String>> res){
            //每行都摆满皇后时，则产生了一种解法
            if(row==n){
                res.add(chsToList(chs));
                return;
            }
            //一行一行地摆放，在确定一行中的那个皇后应该摆在哪一列时，需要当前列是否合法。
            //如果合法，则将皇后放置在当前位置，并进行递归，回溯。
            for(int col=0;col<chs[0].length;col++){
                if(isValid(chs,row,col)){
                    chs[row][col]='Q';
                    //递归
                    backTracing(chs,row+1,n,res);
                    //回溯
                    chs[row][col]='.';
                }
            }
        }
        public List<String> chsToList(char[][] chs){
            List<String> list=new ArrayList<>();
            for(int i=0;i<chs.length;i++){
                list.add(new String(chs[i]));
            }
            return list;
        }
        //判断合法：当前将要摆放'Q'的位置和其他已摆放‘Q’的位置不能在同一列，且不能在同一条45度斜线或135度斜线上。
        //这里判断是否在同一条斜线上可通过当前将要摆放'Q'的位置和其他已摆放‘Q’的位置横坐标之差和纵坐标之差的绝对值是否相等来判断。
        public boolean isValid(char[][] chs,int x,int y){
            for(int i=0;i<=x;i++){
                for(int j=0;j<chs[0].length;j++){
                    if(chs[i][j]=='Q'&&(j==y||Math.abs(x-i)==Math.abs(y-j))){
                        return false;
                    }
                }
            }
            return true;
        }
*/
        String[][] strings = new String[n][n];
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                strings[i][j] = ".";
            }
        }

        Backtracking(result,strings,0,n);
        for (List<String> s :result){
            System.out.println(s);
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
    //
    public static List<String> stringToList(String[][] strings, int n){
        List<String> list=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < n; j++) {
                stringBuffer.append(strings[i][j]);
            }
            list.add(stringBuffer.toString());
        }
        return list;
    }
    //回溯
    public static void Backtracking(List<List<String>> result,String[][] strings, int row, int n){
        if(row == n ){
            result.add(stringToList(strings,n));
            return;
        }
        for (int j = 0; j < n; j++) {
            if(check(strings,row,j,n)){
                strings[row][j] = "Q";
                Backtracking(result,strings,row+1,n);
                strings[row][j] = ".";
            }
        }
    }
}
