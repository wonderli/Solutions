import java.util.*;
public class Solution2{
	
	    public int numDecodings(String s){
	        if(s ==null || s.length() ==0){
	            return 0;
	        }
	        int n = s.length();
	        int[] cache = new int[n+1];
	        Arrays.fill(cache, -1);
	        return helper(s, 0, cache);
	    }
	    private int helper(String s, int index, int[] cache){
	        if(index == s.length()){
	            cache[index] = 1;
	            return 1;
	        }
	        if(cache[index] != -1){
	            return cache[index];
	        }
	        if(s.charAt(index) == '0'){
	            cache[index] = 0;
	            return 0;
	        }
	        int count = helper(s, index+1, cache);
	        if(index < s.length() - 1){
	            int a = Integer.valueOf(s.substring(index, index+2));
	            if(a <= 26){
	                count += helper(s, index+2, cache);
	            }
	        }  
	        cache[index] = count;
	        return count;
	    }
	
 
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
