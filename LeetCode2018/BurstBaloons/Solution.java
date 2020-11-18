class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length +2;
        int[] newNums = new int[n];
        for(int i = 0;i< nums.length;i++){
            newNums[i+1]= nums[i];
        }
        newNums[0]=1;
        newNums[n-1]=1;
        
        int[][] dp =new int[n][n];
        for(int left = n-2; left >-1; left--){
            for(int right = left + 2; right < n; right++){
                for(int i =left + 1; i <right; i++){
                    dp[left][right]=Math.max(dp[left][right], newNums[left] * newNums[i] * newNums[right] + dp[left][i]+dp[i][right]);
                }
            }
        }
        return dp[0][n-1];
        
    }
}