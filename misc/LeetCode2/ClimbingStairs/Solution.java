import java.util.*;
public class Solution{
    public int climbStairs(int n) {
        if(n < 2) return n;
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
