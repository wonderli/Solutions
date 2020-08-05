import java.util.*;
public class Solution{
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        int[] coins = {1, 2, 5};
        System.out.println(sol.coinChange(coins, 11));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
