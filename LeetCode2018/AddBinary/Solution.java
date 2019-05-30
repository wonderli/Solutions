import java.util.*;
public class Solution{
	public String addBinary(String a, String b) {
		if(a == null && b == null) return "";
		if(a.length() == 0) return b;
		if(b.length() == 0) return a;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int aLen = a.length();
		int bLen = b.length();
		for(int i = aLen - 1, j = bLen - 1; i>=0 || j >= 0; i--, j--){
			int aInt = i >= 0 ? a.charAt(i) - '0' : 0;
			int bInt = j >= 0 ? b.charAt(j) - '0' : 0;
			int rInt = aInt + bInt + carry >= 2 ? aInt + bInt + carry - 2 : aInt + bInt + carry;
			carry = aInt + bInt + carry >= 2 ? 1 : 0;
			sb.append(rInt);
		}
		if(carry != 0){
			sb.append(carry);
		}
		return sb.reverse().toString();

    }
    public static void main(String args[]){
        Solution sol = new Solution();
	String a = "11";
	String b = "1";
	System.out.println(sol.addBinary(a, b));
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
