class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for(int j = 1; j <= pLen; j++){
            if(p.charAt(j - 1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }
        for(int i = 1; i <= sLen; i++){
            for(int j = 1; j <= pLen; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)== '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        Solution sol = new Solution();
        System.out.println(sol.isMatch(s, p));
    }
}