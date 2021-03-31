import java.util.*;

class Solution {
    int mod = (int)1e9+7;
    public int solve(int n, int faces, int total) {
        int[][] dp = new int[n+1][total+1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= total; j++){
                for(int k = 1; k <= faces; k++){
                    if(j >= k){
                        dp[i][j] = (dp[i][j] + dp[i-1][j- k])%mod;
                    }
                    
                }
            }
        }
        return dp[n][total];
        
        
    }
}