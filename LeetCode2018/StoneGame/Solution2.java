import java.util.*;
public class Solution2{
    int n;
    int dp[][];
    public boolean stoneGame(int[] piles){
        n = piles.length;
        dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        helper(0, piles, 0, n -1);
        return dp[0][n-1] > 0;
    }
    public int helper(int player, int[] piles, int start, int end){
        if(start > end) return 0;
        if(start == end){
            return piles[start];
        }
        if(dp[start][end] != -1) return dp[start][end];

        int stones = 0;
        if(player == 0){
            stones = Math.max(piles[start] + helper(1, piles, start + 1, end), piles[end] + helper(1, piles, start, end - 1));
        }else{
            stones = Math.min(-piles[start] + helper(0, piles, start + 1, end), -piles[end] + helper(0, piles, start, end-1));
        }
        dp[start][end] = stones;
        return stones;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
