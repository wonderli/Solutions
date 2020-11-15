import java.util.*;
public class Solution{
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i = n-1; i>= 0; i--){
            if(s.charAt(i) != '0'){
                dp[i] = dp[i+1];
                if(i < n-1 && Integer.valueOf(s.substring(i, i+2)) <= 26){
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
