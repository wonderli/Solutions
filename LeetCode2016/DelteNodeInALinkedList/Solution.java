import java.util.*;
public class Solution{
	public void deleteNode(ListNode node) {
		if(node == null) return;
		ListNode next = node.next;
		ListNode nextNext = (node.next != null) ? node.next.next : null;
		node.val = next.val;
		node.next = nextNext;
	}

	public static void main(String args[]){
		Solution sol = new Solution();
	}
}
