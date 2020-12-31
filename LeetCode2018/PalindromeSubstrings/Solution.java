import java.util.*;
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n == 0) return 0;
        boolean[][] dp = new boolean[n+1][n+1];
        int count = 0;
        dp[0][0] = true;
        for(int j = 1; j <= n; j++){
            for(int i = 1; i <= j; i++){
                if(s.charAt(j-1) == s.charAt(i-1) && (j - i <= 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
        
    }
}