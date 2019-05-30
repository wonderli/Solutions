import java.util.*;
public class Solution{
	public int lengthOfLastWord(String s) {
		s = s.trim();
		if(s == null || s.length() == 0) return 0;
		int len = s.length();
		int i = len - 1;
		while(i >= 0){
			if(s.charAt(i) != ' ') i--;
			else break;
		}
		return len - i - 1;
	}
	public static void main(String args[]){
		Solution sol = new Solution();
		String s = "Hello world";
		System.out.println(sol.lengthOfLastWord(s));
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; next = null; }
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
