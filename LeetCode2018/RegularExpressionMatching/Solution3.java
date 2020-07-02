import java.util.*;
public class Solution3{
    public boolean isMatch(String s, String p){
        if(s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int j = 2; j <= p.length(); j += 2){
			if(p.charAt(j-1) == '*' && dp[0][j-2]){
				dp[0][j] = true;
			}
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
				char currS = s.charAt(i - 1);
				char currP = p.charAt(j - 1);
				if(currP == '.'){
					dp[i][j] = dp[i-1][j-1];
				}
				if(currS == currP){
					dp[i][j] = dp[i-1][j-1];
				}
				if( currP == '*'){
					char prev = p.charAt(j - 2);
					if(prev != '.' && prev != currS){
						dp[i][j] = dp[i][j-2];
					}else {
						dp[i][j] = dp[i][j-2] || dp[i-1][j-2] || dp[i-1][j];
					}
				}
            }
        }
        return dp[s.length()][p.length()];
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
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
