import java.util.*;
public class Solution{
	public String countAndSay(int n) {
		if(n == 1) return "1";
		if(n == 2) return "11";
		return count(countAndSay(n-1));
	}
	public String count(final String s){
		if(s.length() == 0) return "1";
		StringBuilder ret = new StringBuilder();;
		int i = 1;
		int count = 1;
		while( i < s.length()){
			if(s.charAt(i) == s.charAt(i - 1)){
				count++;
			}else{
				ret = ret.append(Integer.toString(count)).append(s.charAt(i-1));
				count = 1;
			}
			i++;
		}
		ret.append(Integer.toString(count)).append(s.charAt(i-1));
		return ret.toString();
	}
	public static void main(String args[]){
		Solution sol = new Solution();
		//System.out.println(sol.countAndSay(1));
		System.out.println(sol.countAndSay(3));
		System.out.println(sol.countAndSay(4));
		System.out.println(sol.countAndSay(5));
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
