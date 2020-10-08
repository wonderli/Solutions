import java.util.*;
public class Solution3{
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount +1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i =0; i<=amount; i++){
            for(int j = 0; j <coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]+1);
                }
            }
        }
        return dp[amount] == amount +1?-1 : dp[amount];
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
