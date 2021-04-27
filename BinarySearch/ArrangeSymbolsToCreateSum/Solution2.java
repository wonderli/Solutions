import java.util.*;
/**

You are given a list of non-negative integers nums and an integer target. Return the number of ways there are to arrange + and - in nums such that the expression equals to target.

Constraints

n ≤ 20 where n is the length of nums
m ≤ 1,000 where m is the sum of nums
Example 1
Input
nums = [1, 2, 2, 2, 1]
target = 6
Output
2
Explanation
We can have -1 + 2 + 2 + 2 + 1 and 1 + 2 + 2 + 2 - 1


*/
class Solution {
    public int solve(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][3000];
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        return helper(nums, target, dp, 0);
    }
    private int helper(int[] nums, int target, int[][] dp, int i){
        int n = nums.length;
        if(i == n) return (target == 0) ? 1 : 0;
        if(dp[i][target+1000] != -1){
            return dp[i][target+1000];
        }
        int result = helper(nums, target + nums[i], dp, i+1);
        result += helper(nums, target - nums[i], dp, i+1);
        dp[i][target + 1000] = result;
        return result;
    }
}