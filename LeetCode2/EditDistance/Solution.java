import java.util.*;
public class Solution{
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return 0;
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        int len1 = word1.length();
        int len2 = word2.length();
        int dp[][] = new int[len1+1][len2+1];
        for(int i = 0; i <= len1; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= len2; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                int cost = 1;
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    cost = 0;
                }
                dp[i][j] = Math.min(Math.min(dp[i][j-1] + 1, dp[i-1][j]+1), dp[i-1][j-1]+cost);
            }
        }
        return dp[len1][len2];
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
