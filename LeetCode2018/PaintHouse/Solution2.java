import java.util.*;
public class Solution2 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n+1][3];
        for(int i = 1; i <= n; i++){
            dp[i][0] = Math.min(dp[i-1][1] + costs[i-1][1], dp[i-1][2] + costs[i-1][2]);            
            dp[i][1] = Math.min(dp[i-1][0] + costs[i-1][0], dp[i-1][2] + costs[i-1][2]);
            dp[i][2] = Math.min(dp[i-1][0] + costs[i-1][0], dp[i-1][1] + costs[i-1][1]);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            min = Math.min(min, dp[n][i]);
        }
        
        return min;
        
    }
}
