import java.util.*;
public class Solution{
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int end = 0;
        int max = 0;
        for(int j = 0; j < len; j++){
            for(int i = 0; i <= j; i++){
                if(s.charAt(i) == s.charAt(j) &&  (j - i <= 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                }
                if(dp[i][j] && max < j - i + 1){
                    max = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("babad"));
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
