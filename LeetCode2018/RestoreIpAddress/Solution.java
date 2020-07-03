import java.util.*;

public class Solution {
	List<String> res = new ArrayList<>();

	public List<String> restoreIpAddresses(String s) {

		if (s == null || s.length() == 0 || s.length() > 12)
			return res;

		String curr = new String();
		helper(0, s, curr, 0);
		return res;
	}

	public void helper(int index, String s, String curr, int section) {
		if (section == 4) {
			if (index == s.length()) {
				res.add(curr.substring(0, curr.length() - 1));
				return;
			}
		}

		for (int i = index + 1; i <= s.length() && i <= index + 3; i++) {
			if (Integer.parseInt(s.substring(index, i)) <= 255) {
				helper(i, s, curr + s.substring(index, i) + ".", section + 1);
				if (s.charAt(index) == '0') {
					break;
				}
			}
		}

	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		String s = "25525511135";
		System.out.println(sol.restoreIpAddresses(s));
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
