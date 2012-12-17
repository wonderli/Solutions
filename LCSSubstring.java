//Longest Common Substring
//LCS
public class LCSSubstring{
    public static String lcssub(String a, String b){
        int m = a.length();
        int n = b.length();
        if(a == null || a.isEmpty() || b == null || b.isEmpty()){
            return "";
        }
        char ac[] = a.toCharArray();
        char bc[] = b.toCharArray();
        int[][] r = new int[m][n];
        int maxLen = 0;
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        int last = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(ac[i] !=  bc[j]) r[i][j] = 0;
                else{
                    if(i == 0 || j == 0) r[i][j] = 1;
                    else r[i][j] = r[i-1][j-1] + 1;
                }
                if(r[i][j] > maxLen){
                    maxLen = r[i][j];
                    curr = i - r[i][j] + 1;
                    if(curr == last){
                        sb.append(ac[i]);
                    }else{
                        last = curr;
                        sb = new StringBuilder();
                        sb.append(a.substring(last, i+1));
                    }
                }
            }
        }
        return sb.toString();
    }
    public static void main(String args[]){
        String a = new String("abcdabd");
        String b = new String("abdabca");
        System.out.println(a);
        System.out.println(b);
        System.out.println(lcssub(a,b));
    }
}
