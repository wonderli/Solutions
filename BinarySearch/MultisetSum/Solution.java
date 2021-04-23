import java.util.*;

/**

Given a list of unique positive integers nums and a positive integer k, return the number of unique combinations that sum up to k. You may reuse numbers when creating combinations.

Constraints

n ≤ 25 where n is the length of nums
1 ≤ nums[i] ≤ 250 for all 0 ≤ i < n
1 ≤ k ≤ 500
Example 1
Input
nums = [1, 2, 3]
k = 2
Output
2
Explanation
We can make 2 with [1, 1] and [2].

*/
class Solution {
    public int solve(int[] nums, int k) {
        int[] dp = new int[k+1];
        dp[0] = 1;
        int n = nums.length;
        for(int j = 0; j < n; j++){
            for(int i = 0; i <= k; i++){
                if(i - nums[j] >= 0){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[k];
    }
}