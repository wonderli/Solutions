import java.util.*;
class Solution {
    String s1;
    String s2;
    String s3;
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        dp = new Boolean[s3.length()+1][s3.length()+1];
        dfs(0, 0, 0);
        return dp[s3.length()][s3.length()] == null ? false : dp[s3.length()][s3.length()];
    }
    private boolean dfs(int i, int j, int k){
        if(k == s3.length()){
            dp[s3.length()][s3.length()] = (i == s1.length() && j == s2.length());
            return dp[s3.length()][s3.length()];
        }
        if(dp[i][j] != null) return dp[i][j];
        char a = i < s1.length() ? s1.charAt(i) : '#';
        char b = j < s2.length() ? s2.charAt(j) : '#';
        char c = k < s3.length() ? s3.charAt(k) : '?';
        if(a == c || b == c){
            if(a == b){
                dp[i][j] = dfs(i+1, j, k+1) || dfs(i, j+1, k+1);
            }else if(a == c){
                dp[i][j] = dfs(i+1, j, k+1);
            }else{
                dp[i][j] = dfs(i, j+1, k+1);
            }
        }else{
            dp[i][j] = false;
        }
        return dp[i][j];
    }
}