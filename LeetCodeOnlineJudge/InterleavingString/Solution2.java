// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",
//
// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false. 
public class Solution2{
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 == 0) return s2.equals(s3);
        if(len2 == 0) return s1.equals(s3);
        boolean dp[][] = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for(int i = 0; i <= len1; i++){
            for(int j = 0; j <= len2; j++){
                if(i == 0 && j == 0) continue;
                if(i != 0){
                    dp[i][j] = dp[i][j] || dp[i-1][j] && (s1.charAt(i-1) == s3.charAt(i + j - 1));
                } 
                if(j != 0){
                    dp[i][j] = dp[i][j] || dp[i][j-1] && (s2.charAt(j-1) == s3.charAt(i + j - 1));
                }
                
            }
        }
        return dp[len1][len2];
    }
    public static void main(String args[]){
        Solution2 s = new Solution2();
        String s1 = new String("a");
        String s2 = new String("b");
        //String s3 = new String("aadbbcbcac");
        String s3 = new String("ab");
        System.out.println(s.isInterleave(s1, s2, s3));

    }
}
