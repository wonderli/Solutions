import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] |= dp[j] && wordDict.contains(s.substring(j, i));
            }
        }
        return dp[n];
    }
     public static void main(String[] args) {
         Solution sol = new Solution();
         String a = "a";
         List<String> list = Arrays.asList("a", "code");
         System.out.println(sol.wordBreak(a, list));
      }
}