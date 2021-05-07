import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n == 1) return nums[0];
        if(n == 2) return Math.min(nums[0], nums[1]);
        if(n == 3) return Math.min(Math.min(nums[0], nums[1]), nums[2]);
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2];
        for(int i = 3; i < n; i++){
            dp[i] = nums[i] + Math.min(dp[i-1], Math.min(dp[i-2], dp[i-3]));
        }
        return Math.min(dp[n-1], Math.min(dp[n-2], dp[n-3]));
    }
}