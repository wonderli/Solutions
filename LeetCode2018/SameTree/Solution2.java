import java.util.*;
public class Solution2{
	public boolean isSameTree(TreeNode p, TreeNode q) {
	        if(p == null || q == null) return p == q;
	        Stack<TreeNode> s1 = new Stack<>();
	        Stack<TreeNode> s2 = new Stack<>();
	        TreeNode curr1 = p;
	        TreeNode curr2 = q;
	        while(!s1.isEmpty() || curr1 != null){
	            int count1 = 0;
	            while(curr1!= null){
	                s1.push(curr1);
	                curr1 = curr1.left;
	                count1++;
	            }
	            int count2= 0;
	            while(curr2 != null){
	                s2.push(curr2);
	                curr2 = curr2.left;
	                count2++;
	            }
	            if(count1 != count2) return false;

	            curr1 = s1.pop();
	            curr2 = s2.pop();
	            if(curr1 != null && curr2 != null && curr1.val != curr2.val) return false;
	            curr1 = curr1.right;
	            curr2 = curr2.right;
	        }
           
            
	        return true;
	    }
}
class ListNode {
    int val;
    ListNode next;
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
