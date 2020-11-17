import java.util.*;
public class Solution2{
    public int numSquares(int n){
        if(n <=3) return n;
        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++){
            dp[i] = i;
            for(int j = 1; j*j <= i; j++){
                dp[i]= Math.min(dp[i], dp[i - j*j]+1);
            }
        }
        return dp[n];
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
