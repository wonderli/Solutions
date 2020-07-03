import java.util.*;

public class Solution {
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if(digits == null || digits.length() == 0) return res;
		String[] pad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		String curr = new String();
		helper(0, pad, curr, digits, res);
		return res;
	}

	public void helper(int index, String[] pad, String curr, String digits, List<String> res) {
		if (index == digits.length()) {
			res.add(curr);
			return;
		}
		String currPad = pad[Character.getNumericValue(digits.charAt(index))];
		for (int j = 0; j < currPad.length(); j++) {
			helper(index + 1, pad, curr + currPad.charAt(j), digits, res);
		}
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		System.out.println(sol.letterCombinations("23"));
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
