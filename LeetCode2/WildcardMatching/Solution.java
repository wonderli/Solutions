import java.util.*;
public class Solution{
    public boolean isMatch(String s, String p) {
        if(p == null || s == null) return false;
        if(p.length() == 0) return s.length() == 0;
        int sLen = s.length();
        int pLen = p.length();
        if(sLen > 3000) return false;
        boolean dp[][] = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for(int i = 0; i <= sLen; i++){
            for(int j = 0; j <= pLen; j++){
                if(i > 0 && j != 0){
                    dp[i][j] = dp[i-1][j] && (p.charAt(j-1) == '*');
                }
                if(j > 0){
                    dp[i][j] = dp[i][j] || dp[i][j-1] && p.charAt(j-1) == '*';
                }
                if(i > 0 && j > 0){
                    dp[i][j] = dp[i][j] || (dp[i-1][j-1] && (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?'));
                }
            }
        }
        return dp[sLen][pLen];
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.isMatch("aa", "a"));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
