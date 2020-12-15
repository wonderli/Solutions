import java.util.*;
/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode() {}
*     ListNode(int val) { this.val = val; }
*     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
* }
*/
class Solution {
	int carry = 1;
	public ListNode plusOne(ListNode head) {
		if(head == null) return new ListNode(1);
		ListNode curr = helper(head);
		if(carry != 0){
			ListNode newHead = new ListNode(carry);
			newHead.next = curr;
			return newHead;
		}
		return curr;
	}
    
	private ListNode helper(ListNode head){
		if(head == null) return null;
		helper(head.next);
		int val = head.val;
		int v = (val + carry)%10;
		carry = (val + carry)/10;
		head.val = v;
		return head;
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode() {};
	ListNode(int x) { val = x; next = null; }
}
