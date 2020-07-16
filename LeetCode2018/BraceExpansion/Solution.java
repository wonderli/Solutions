import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
	public String[] expand(String S) {
		List<List<Character>> list = new ArrayList<>();
		List<Character> queue = new ArrayList<>();
		boolean start = false;
		for (char c : S.toCharArray()) {
			if (c == ',' || c == ' ')
				continue;

			if (c == '{') {
				start = true;
				queue = new ArrayList<>();
			} else if (c == '}') {
				start = false;
				Collections.sort(queue);
				list.add(queue);
				queue = new ArrayList<>();
			} else {
				if (start) {
					queue.add(c);
				} else {
					List<Character> tmp = new ArrayList<>();
					tmp.add(c);
					list.add(tmp);
				}
			}
		}
		List<String> res = new ArrayList<>();
		helper(0, list, res, "");
		return res.toArray(new String[0]);
	}

	public void helper(int index, List<List<Character>> list, List<String> res, String curr) {
		if (curr.length() == list.size()) {
			res.add(curr);
			return;
		}
		for (int i = index; i < list.size(); i++) {
			List<Character> e = list.get(i);
			for (char c : e) {
				helper(i + 1, list, res, curr + c);
			}
		}
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		String s = "{a, b, c}d{e, f}";
		System.out.println(Arrays.toString(sol.expand(s)));

	}
}