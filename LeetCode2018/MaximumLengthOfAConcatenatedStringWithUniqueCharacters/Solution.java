import java.util.*;

public class Solution {
	String res = new String();

	public int maxLength(List<String> arr) {
		String curr = new String();
		helper(0, arr, curr);
		return res.length();
	}

	public void helper(int index, List<String> arr, String curr) {

		if (curr.length() > res.length()) {
			res = curr;
		}

		if (index == arr.size()) {
			return;
		}
		for (int i = index; i < arr.size(); i++) {
			String arrCurr = arr.get(i);
			if (isUnique(curr, arrCurr)) {
				helper(i + 1, arr, curr + arrCurr);
			}
		}
	}

	public boolean isUnique(String curr, String arrCurr) {
		boolean[] map = new boolean[26];
		for (int i = 0; i < curr.length(); i++) {
			char c = curr.charAt(i);
			map[c - 'a'] = true;
		}
		for (char c : arrCurr.toCharArray()) {
			if (map[c - 'a']) {
				return false;
			}
			map[c - 'a'] = true;
		}
		return true;
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
//        List<String> arr = Arrays.asList("un", "iq", "ue");
        List<String> arr = Arrays.asList("cha","r","act","ers");
//        List<String> arr = Arrays.asList("jnfbyktlrqumowxd","mvhgcpxnjzrdei");
//		List<String> arr = Arrays.asList("yy", "bkhwmpbiisbldzknpm");
		System.out.println(sol.maxLength(arr));

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
