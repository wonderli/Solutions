import java.util.*;
public class Solution{
	public boolean isSubsequence(String s, String t) {
	        if(s == null || t == null) return false;
	        int i = 0;
	        int j = 0;
	        int sLen = s.length();
	        int tLen = t.length();
	        while( i < sLen && j < tLen){
	            if(s.charAt(i) == t.charAt(j)){
	                i++;
	            }
	            j++;
	        }
	        return i == s.length();
	    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
