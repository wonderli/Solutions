import java.util.*;
public class Solution{
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return null;
		ListNode dummy = new ListNode(0);
		ListNode curr = head;
		ListNode p = dummy;
		while(curr != null){
			if(curr.val != val){
				p.next = curr;
				p = p.next;
			}
			curr = curr.next;
		}
		p.next = null;
		return dummy.next;
	}
	public void printListNode(ListNode head){
		if(head == null) return;
		while(head != null){
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}
	public static void main(String args[]){
		Solution sol = new Solution();
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		sol.printListNode(l);
		ListNode x = sol.removeElements(l, 1);
		sol.printListNode(x);

	}
}
