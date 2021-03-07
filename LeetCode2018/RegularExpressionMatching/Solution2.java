import java.util.*;

public class Solution2 {

	Boolean[][] dp;
	public boolean isMatch(String s, String p) {
		dp = new Boolean[s.length() + 1][p.length() + 1];
		return dp(0, 0, s.toCharArray(), p.toCharArray());
	}
	public boolean dp(int i, int j, char[] s, char[] p) {
		if(dp[i][j] != null) {
			return dp[i][j] == true;
		}
		
		boolean res;
		
		if(j == p.length) {
			res = i == s.length;
		} else {
			boolean first = (i < s.length && (p[j] == s[i] || p[j] == '.'));
			if(j + 1 < p.length && p[j+1] == '*') {
				res = dp(i, j+2, s, p) || (first && dp(i+1, j, s, p));
			} else {
				res = first && dp(i+1, j+1, s, p);
			}
		}
		dp[i][j] = res ? true : false;

		return res;		
	}

	public void helper(int x, int y, char[] s, char[] p) {
	}

	public static void main(String args[]) {
		Solution2 sol = new Solution2();
		String s = "mississippi";
		String p = "mis*is*p*.";
		System.out.println(sol.isMatch(s, p));
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
