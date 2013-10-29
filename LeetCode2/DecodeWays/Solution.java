import java.util.*;
public class Solution{
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int dp[] = new int[len+1];
        dp[len] = 1;
        for(int i = len - 1; i >= 0; i--){
            if(s.charAt(i) != '0'){
                dp[i] = dp[i + 1];
                if(i < len - 1 && Integer.parseInt(s.substring(i, i+2)) <= 26){
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
