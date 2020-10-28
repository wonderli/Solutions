import java.util.*;
public class Solution3{
	
	public ListNode detectCycle(ListNode head) {
	        if(head == null) return null;
	        ListNode slow = head;
	        ListNode fast = head;
	        do{
	            slow = slow.next;
	            fast = fast.next != null? fast.next.next : null;
	        }while(slow !=null && fast !=null && slow != fast);
	        if(fast == null) return null;
	        slow = head;
	        while(slow != fast){
	            slow = slow.next;
	            fast = fast.next;
	        }
	        return slow;
	    }
		
		
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int x, ListNode n){ val = x; next = n;}
}