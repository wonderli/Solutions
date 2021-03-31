import java.util.*;
public class Solution{
	public ListNode reverseList(ListNode head) {
		if(head == null) return null;
		if(head.next == null) return head;
		ListNode begin = head;
		ListNode p1 = head;
		ListNode p2 = head.next;
		while(p2 != null){
			ListNode next = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = next;
		}
		begin.next = null;
		return p1;
	}

	public static void main(String args[]){
		Solution sol = new Solution();
	}
}
