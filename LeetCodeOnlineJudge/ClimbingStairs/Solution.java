//You are climbing a stair case. It takes n steps to reach to the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
public class Solution{
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        if(n <= 0) return 0;
        if(n == 1){
            return 1;
        }
        if(n == 2) return 2;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String args[]){
        
    }
}
