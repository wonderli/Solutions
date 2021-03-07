import java.util.*;

public class Solution {
	public String minWindow(String s, String t) {
		if (s.length() < t.length())
			return new String();
		if (t.length() == 0)
			return s;
		int sLen = s.length();
		int tLen = t.length();
		int needToFind[] = new int[256];
		int hasFound[] = new int[256];
		for (int i = 0; i < 256; i++) {
			needToFind[i] = 0;
			hasFound[i] = 0;
		}
		for (int i = 0; i < tLen; i++) {
			needToFind[t.charAt(i)]++;
		}
		int count = 0;
		int minLen = Integer.MAX_VALUE;
		int minBegin = 0;
		int minEnd = 0;
		for (int begin = 0, end = 0; end < sLen; end++) {
			if (needToFind[s.charAt(end)] == 0)
				continue;
			hasFound[s.charAt(end)]++;
			if (hasFound[s.charAt(end)] <= needToFind[s.charAt(end)]) {
				count++;
			}
			if (count == tLen) {
				while (needToFind[s.charAt(begin)] == 0 || hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)]) {
					if (hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)]) {
						hasFound[s.charAt(begin)]--;
					}
					begin++;
				}
				int winLen = end - begin + 1;
				if (winLen < minLen) {
					minBegin = begin;
					minEnd = end;
					minLen = winLen;
				}
			}
		}
		if (count != tLen)
			return new String();
		return s.substring(minBegin, minBegin + minLen);

	}

	public static void main(String args[]) {
		Solution sol = new Solution();
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
