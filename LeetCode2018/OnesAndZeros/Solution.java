import java.util.*;
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String s : strs){
            int[] count = count(s);
            for(int zeros = m; zeros >= count[0]; zeros--){
                for(int ones = n; ones >= count[1]; ones--){
                    dp[zeros][ones] = Math.max( 1 + dp[zeros - count[0]][ones - count[1]], dp[zeros][ones]);
                }
            }
        }
        return dp[m][n];
    }
    private int[] count(String s){
        int[] count = new int[2];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - '0']++;
        }
        return count;
    }
}