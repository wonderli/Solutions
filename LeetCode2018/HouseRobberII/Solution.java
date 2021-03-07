import java.util.*;
public class Solution{
    Integer[] dp ;
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        dp = new Integer[nums.length];
        int a = helper(nums, 0, nums.length - 2);
        dp = new Integer[nums.length];
        int b = helper(nums, 1, nums.length -1);
        return Math.max(a, b);
    }
    public int helper(int[] nums, int start, int i){
        if(i < start ) return 0;
        if(dp[i] != null) return dp[i];
        dp[i] = Math.max(helper(nums, start, i -2) + nums[i], helper(nums, start, i - 1));
        return dp[i];
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
