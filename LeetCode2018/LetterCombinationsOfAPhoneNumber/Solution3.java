import java.util.*;

public class Solution3 {

	private static Map<Integer, String> map = new HashMap<>();
	static {
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
	}

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return res;
		String[] pad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		Queue<String> queue = new LinkedList<>();
		queue.add("");
		int index = 0;
		while (index < digits.length()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String s = queue.poll();
				StringBuilder sb = new StringBuilder(s);
				String currPad = map.get(Character.getNumericValue(digits.charAt(index)));
				for (char c : currPad.toCharArray()) {
					sb.append(c);
					queue.add(sb.toString());
					sb.setLength(sb.length() - 1);
				}
			}
			index++;

		}
		res.addAll(queue);
		return res;
	}

	}

	public static void main(String args[]) {
		Solution3 sol = new Solution3();
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
