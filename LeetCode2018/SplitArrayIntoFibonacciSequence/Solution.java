import java.util.*;

public class Solution {
	public List<Integer> splitIntoFibonacci(String S) {
		List<Integer> res = new ArrayList<>();
		helper(S, res, 0);
		return res;
	}

	private boolean helper(String s, List<Integer> res, int index) {
		if (index == s.length() && res.size() >= 3) {
			return true;
		}

		for (int i = index; i < s.length(); i++) {
			if (s.charAt(index) == '0' && i > index) {
				break;
			}
			long num = Long.parseLong(s.substring(index, i + 1));
			if (num > Integer.MAX_VALUE) {
				break;
			}
			int size = res.size();
			if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
				break;
			}
			if (size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
				res.add((int) num);
				if (helper(s, res, i + 1)) {
					return true;
				}
				res.remove(res.size() - 1);
			}
		}
		return false;

	}

	public static void main(String args[]) {
		Solution sol = new Solution();
//        String s = "112358130";
		String s = "1101111";
		System.out.println(sol.splitIntoFibonacci(s));
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
