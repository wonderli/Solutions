class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length <= 1) return false;
        int sum = 0;
        for(int e : nums){
            sum += e;
        }
        if(sum % 2 == 1) return false;
        int target = sum/2;
        int n = nums.length;
        Boolean[][] memo = new Boolean[n+1][target+1];
        return dfs(nums, n-1, target, memo);
    }
    private boolean dfs(int[] nums, int n, int target, Boolean[][] memo){
        if(target == 0){
            return true;
        }
        if(n == 0 || target < 0){
            return false;
        }
        if(memo[n][target]!= null){
            return memo[n][target];
        }
        boolean result = dfs(nums, n-1, target, memo)||dfs(nums, n-1, target - nums[n-1], memo);
        memo[n][target] = result;
        return result;
    }
}