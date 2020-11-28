class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n <=1) return false;
        int sum = 0;
        for(int e : nums){
            sum += e;
        }
        if(sum %2 != 0) return false;
        int target = sum/2;
        
        boolean[][] dp = new boolean[n+1][target+1];
        dp[0][0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= target; j++){
                int curr = nums[i-1];
                if(j < curr){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - curr];
                }
            }
        }
        return dp[n][target];
    }
}