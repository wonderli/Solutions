import java.util.*;

public class Solution {
	List<String> res = new ArrayList<>();

	public List<String> generatePalindromes(String s) {
		int numOdds = 0;
		int[] map = new int[256];
		for (char c : s.toCharArray()) {
			map[c]++;
			numOdds = (map[c] & 1) == 1 ? numOdds + 1 : numOdds - 1;
		}
		if (numOdds > 1)
			return res;
		String mid = "";
		int len = 0;
		for (int i = 0; i < 256; i++) {
			if (map[i] > 0) {
				if ((map[i] & 1) == 1) {
					mid = "" + (char) i;
					map[i]--;
				}
			}
			map[i] /= 2;
			len += map[i];
		}
		helper(map, len, "", mid);
		return res;
	}

	public void helper(int[] map, int len, String s, String mid) {
		if (s.length() == len) {
			StringBuilder sb = new StringBuilder(s).reverse();
			res.add(s + mid + sb.toString());
			return;
		}
		for (int i = 0; i < 256; i++) {
			if (map[i] > 0) {
				map[i]--;
				helper(map, len, s + (char) i, mid);
				map[i]++;
			}
		}
	}

	public static void main(String args[]) {
		System.out.println(new Solution().generatePalindromes("aabb"));
		System.out.println(new Solution().generatePalindromes("abc"));
		System.out.println(new Solution().generatePalindromes("aabbhijkkjih"));
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
