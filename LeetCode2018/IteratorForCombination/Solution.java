import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Solution sol = new Solution();
		CombinationIterator ci = new CombinationIterator("abc", 2);
		while (ci.hasNext()) {
			System.out.println(ci.next());
		}
	}

}

class CombinationIterator {

	List<String> res = new ArrayList<>();
	int i = 0;

	public CombinationIterator(String characters, int combinationLength) {
		helper(0, combinationLength, characters, new String());
		System.out.println(res);
	}

	public void helper(int index, int num, String s, String curr) {
		if (curr.length() == num) {
			res.add(curr);
		}
		for (int i = index; i < s.length(); i++) {
			helper(i + 1, num,  s, curr + s.charAt(i));
		}
	}

	public String next() {
		String s = null;
		if (hasNext()) {
			s = res.get(i);
			i++;
		}
		return s;
	}

	public boolean hasNext() {
		return i < res.size() ? true : false;
	}
}
