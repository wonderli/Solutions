import java.util.*;
public class Solution2{
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        for(int i = 0; i <= n; i++){
            if(dp[i]){
                continue;
            }
            for(int k = 1; i + k * k <= n;k++){
                dp[i + k*k] = true;
            }
        }
        return dp[n];
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
