import java.util.*;

public class Solution {

	public List<String> letterCasePermutation(String S) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		helper(0, S, sb, res);
		return res;
	}

	public void helper(int index, String S, StringBuilder sb, List<String> res) {
		if (sb.length() == S.length()) {
			res.add(sb.toString());
			return;
		}
		for (int i = index; i < S.length(); i++) {
			char c = S.charAt(i);
			if (Character.isDigit(c)) {
				StringBuilder news = new StringBuilder(sb);
				news.append(c);
				helper(i + 1, S, news, res);

			} else {
				StringBuilder upper = new StringBuilder(sb);
				upper.append(Character.toUpperCase(c));
				helper(i + 1, S, upper, res);
				StringBuilder lower = new StringBuilder(sb);
				lower.append(Character.toLowerCase(c));
				helper(i + 1, S, lower, res);
			}
		}
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		List<String> res = sol.letterCasePermutation("OD7En5wEUJiP");
		for (String s : res) {
			System.out.println(s);
		}
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
