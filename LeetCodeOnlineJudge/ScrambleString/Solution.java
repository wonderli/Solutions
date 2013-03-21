public class Solution{
    public boolean isScramble(String s1, String s2){
        int len = s1.length();
        if(len != s2.length()) return false;
        boolean dp[][][] = new boolean[len+1][len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(s1.charAt(i) == s2.charAt(j))
                    dp[1][i][j] = true;
            }
        }
        for(int l = 2; l <= len; l++){
            for(int i = 0; i < len - l + 1; i++){
                for(int j = 0; j < len - l + 1; j++){
                    for(int k = 1; k < l; k++){
                        dp[l][i][j] = dp[k][i][j] && dp[l - k][i+k][j+k] || dp[k][i][j + l - k] && dp[l - k][i + k][j];
                        if(dp[l][i][j]) break;
                    }
                }
            }
        }
        return dp[len][0][0];
    }

    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
