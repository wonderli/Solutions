// http://unknownspace.org/article_t/JobHunting/32240015.html
//  Given a string S and a string T, count the number of distinct subsequences of T in S.
//
//  A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//  Here is an example:
//  S = "rabbbit", T = "rabbit"
//
//  Return 3. 
public class Solution{
    public int numDistinct(String S, String T) {
        if(S == null || T == null || S.length() == 0) return 0;
        if(T.length() == 0) return 1;
        int sLen = S.length();
        int tLen = T.length();
        char s[] = S.toCharArray();
        char t[] = T.toCharArray();
        int dp[][] = new int[tLen + 1][sLen + 1];
        for(int i = 0; i <= tLen; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i <= sLen; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i <= tLen; i++){
            for(int j = 1; j <= sLen; j++){
                if(s[j - 1] == t[i - 1]){
                    dp[i][j] = dp[i-1][j -1] + dp[i][j - 1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        return dp[tLen][sLen];
    }
//    public int numDistinct(String S, String T) {
//        if(S.length() == 0) return 0;
//        if(T.length() == 0) return 1;
//        if(S.length() == 1 && T.length() == 1){
//            if(S.charAt(0) == T.charAt(0)) return 1;
//            else return 0;
//        }
//        if(S.charAt(0) != T.charAt(0)) return numDistinct(S.substring(1), T);
//        else return numDistinct(S.substring(1), T.substring(1)) + numDistinct(S.substring(1), T);
//
//    }

    public static void main(String args[]){
        String S = new String("ccc");
        String T = new String("c");
        Solution s = new Solution();
        System.out.println(s.numDistinct(S, T));
    }
}

