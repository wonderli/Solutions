import java.util.ArrayList;
import java.util.List;

class Solution {
	boolean isAdditiveNumber = false;

	public boolean isAdditiveNumber(String num) {
		int len = num.length();
		for (int i = 1; i < (len - 1) / 2; i++) {
			if (num.charAt(0) == '0' && i >= 2)
				break;
			for (int j = i + 1; len - j >= j - 1 && len - j >= i; j++) {
				if (num.charAt(i) == '0' && j - i >= 2)
					break;
				long a = Long.parseLong(num.substring(0, i));
				long b = Long.parseLong(num.substring(i, j));
				if (helper(num.substring(j), a, b)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean helper(String s, long a, long b) {
		if (s.equals(""))
			return true;

		long sum = a + b;
		String ss = Long.valueOf(sum).toString();

		if (!s.startsWith(ss))
			return false;

		return helper(s.substring(ss.length()), b, sum);

	}

	public boolean helper(long prev, long sum, String num) {
		if (num.length() > 1 && num.startsWith("0"))
			return false;
		if (Long.toString(sum).equals(num)) {
			return isAdditiveNumber;
		}
		for (int i = 1; i < num.length(); i++) {
			String cs = num.substring(0, i);
			long c = Long.parseLong(cs);
			if (c == sum) {
				return helper(c, c + prev, num.substring(i));
			}
		}
		return false;
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		// String s = "112358";
//		String s = "198019823962";
		String s = "11111111111011111111111";
		System.out.println(sol.isAdditiveNumber(s));
	}
}
