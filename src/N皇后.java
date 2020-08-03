import java.util.ArrayList;
import java.util.List;

public class N�ʺ� {
    public static void main(String[] args) {
        solveNQueens(4);
    }
    public static List<List<String>> solveNQueens(int n) {
       /*   public void backTracing(char[][] chs,int row,int n,List<List<String>> res){
            //ÿ�ж������ʺ�ʱ���������һ�ֽⷨ
            if(row==n){
                res.add(chsToList(chs));
                return;
            }
            //һ��һ�еذڷţ���ȷ��һ���е��Ǹ��ʺ�Ӧ�ð�����һ��ʱ����Ҫ��ǰ���Ƿ�Ϸ���
            //����Ϸ����򽫻ʺ�����ڵ�ǰλ�ã������еݹ飬���ݡ�
            for(int col=0;col<chs[0].length;col++){
                if(isValid(chs,row,col)){
                    chs[row][col]='Q';
                    //�ݹ�
                    backTracing(chs,row+1,n,res);
                    //����
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
        //�жϺϷ�����ǰ��Ҫ�ڷ�'Q'��λ�ú������Ѱڷš�Q����λ�ò�����ͬһ�У��Ҳ�����ͬһ��45��б�߻�135��б���ϡ�
        //�����ж��Ƿ���ͬһ��б���Ͽ�ͨ����ǰ��Ҫ�ڷ�'Q'��λ�ú������Ѱڷš�Q����λ�ú�����֮���������֮��ľ���ֵ�Ƿ�������жϡ�
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
    //����
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
