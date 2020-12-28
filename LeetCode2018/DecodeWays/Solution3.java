import java.util.*;
class Solution3 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= n; i++){
            if(s.charAt(i-1) != '0'){
                dp[i] = dp[i-1];
            }
            int twoDigits = Integer.valueOf(s.substring(i-2, i));
            if(twoDigits >= 10 && twoDigits <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
