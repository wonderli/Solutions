//Given a string S, find the longest palindromic substring in S.
public class Q3{
    public static String lsp(String s){
        int n = s.length();
        int size = 1000;
        int begin = 0;
        int maxLen = 0;
        boolean[][] mark = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                mark[i][j] = false;
            }
        }
        for(int i = 0; i < size; i++) {
            mark[i][i] = true; 
        }
        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1)){
                mark[i][i+1] = true;
                begin = i;
                maxLen = 2;
            }
        }
        for(int len = 3; len <= n; len++) {
            for(int i = 0; i < n - len + 1; i++){
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && mark[i+1][j-1]){
                    mark[i][j] = true;
                    begin = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(begin, maxLen + begin);
    }

    public static void main(String args[]) {
        String s = new String("abbab");
        System.out.println(lsp(s));
    }
}
