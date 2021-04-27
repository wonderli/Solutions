import java.util.*;

/**
Given an integer n, find two or more integers such that their sum is equal to n, where the product of these integers is maximized, and return this product.

Constraints

n ≤ 100,000
Example 1
Input
n = 11
Output
54
Explanation
3  + 3 + 3 + 2 = 11 and 3 * 3 * 3 * 2 = 54

*/
class Solution {
    public int solve(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j , dp[i-j]));
            }
        }
        return dp[n];
    }
}