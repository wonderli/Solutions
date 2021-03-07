import java.util.*;

class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		if (n == 0)
			return result;
		if (n == 1) {
			result.add("()");
			return result;
		}
		String curr = new String();
		helper(result, curr, n, n);
		return result;
	}

	public void helper(List<String> result, String curr, int leftNum, int rightNum) {
		if(leftNum < 0 || leftNum > rightNum) return;
		if(leftNum == 0 && rightNum == 0) {
			result.add(curr);
			return;
		}

		helper(result, curr + "(", leftNum - 1, rightNum);
		helper(result, curr + ")", leftNum, rightNum - 1);

	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		List<String> res = sol.generateParenthesis(3);
		for (String s : res) {
			System.out.println(s);
		}

	}
}
