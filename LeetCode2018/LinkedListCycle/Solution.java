import java.util.*;
public class Solution{
	public boolean hasCycle(ListNode head) {
	        if(head == null || head.next == null) return false;
	        ListNode p1 = head;
	        ListNode p2 = head;
	        while(p2.next != null){
	            p1 = p1.next;
	            p2 = p2.next.next;
	            if(p1 == p2) return true;
	        }
	        return false;
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
