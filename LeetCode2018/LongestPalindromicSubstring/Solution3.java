import java.util.*;
public class Solution3{
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        int start = 0;
        int resLen = 0;
        int sLen = s.length();
        boolean[][] dp = new boolean[sLen][sLen];
        for(int len = 1; len <= sLen; len++){
            for(int i = 0; i < sLen && i + len - 1 < sLen; i++){
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)){
                    if(len <= 2){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && resLen < len){
                    resLen = len;
                    start = i;
                }
            }
        }
        return s.substring(start, start + resLen);
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
