import java.util.*;
public class Solution{
    public boolean winnerSquareGame(int n) {
        boolean[] dp =new boolean[n+1];
        for(int i = 0; i < dp.length; i++){
            for(int k = 1; k * k <= i; k++){
                if(dp[i - k *k ] ==false){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
