class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;
        if(costs.length == 1){
            if(costs[0].length == 0) return 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < costs[0].length; i++){
                min = Math.min(min, costs[0][i]);
            }
            return min;
        }
        
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        
        for(int i = 0; i < k; i++){
            dp[0][i] = costs[0][i];
        }
        int result = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < k; j++){
                int min = Integer.MAX_VALUE;
                for(int p = 0; p < k; p++){
                    if(p == j) continue;
                    min = Math.min(dp[i-1][p], min);
                }
                dp[i][j] = min + costs[i][j];
                if(i == n - 1){
                    result = Math.min(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}