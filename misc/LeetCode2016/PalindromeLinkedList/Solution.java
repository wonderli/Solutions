import java.util.*;
public class Solution{
	public boolean isPalindrome(ListNode head) {
		if(head == null) return true;
		int len = checkListLength(head);
		int start = len % 2 == 0 ? len/2 : len/2 + 1;
		ListNode p = head;
		for(int i = 0; i < start; i++){
			p = p.next;
		}
		ListNode r = reverseList(p);
		for(ListNode p1 = head, p2 = r; p1 != null && p2 != null; p1 = p1.next, p2 = p2.next){
			if(p1.val != p2.val) return false;
		}
		return true;
	}
	public ListNode reverseList(ListNode head){
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
	public int checkListLength(ListNode head){
		if(head == null) return 0;
		ListNode p = head;
		int len = 0;
		while(p != null){
			p = p.next;
			len++;
		}
		return len;
	}
	public void printList(ListNode h){
		if(h == null) return; 
		while(h != null){
			System.out.print(h.val + "->");
			h = h.next;
		}
		System.out.println();
	}

	public static void main(String args[]){
		Solution sol = new Solution();
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		p1.next = p2;
		sol.printList(p1);
		ListNode p3 = sol.reverseList(p1);
		sol.printList(p3);
		p1 = new ListNode(1);
		p1.next = new ListNode(2);
		p1.next.next = new ListNode(1);
		p1.next.next = new ListNode(2);
		System.out.println(sol.isPalindrome(p1));
	}
}
