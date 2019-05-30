import java.util.*;
public class Solution{
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		if(length(head) == 1) return head;
		ListNode root = new ListNode(-1);
		root.next = head;
		ListNode curr = head.next;
		ListNode prev = head;
		while(curr != null){
			if(curr.val != prev.val){
				prev.next = curr;
				prev = prev.next;
			}
			curr = curr.next;
		}
		prev.next = null;
		return root.next;
	}
	public int length(ListNode head){
		if(head == null) return 0;
		int i = 0;
		while(head != null){
			head = head.next;
			i++;
		}
		return i;
	}
	public void print(ListNode head){
		if(head ==null) return;
		while(head!= null){
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}
	public ListNode create(int... arr){
		ListNode l = new ListNode(0);
		ListNode head = l;
		for(int i = 0; i < arr.length; i++){
			l.next = new ListNode(arr[i]);
			l = l.next;
		}
		return head.next;
	}


    public static void main(String args[]){
        Solution sol = new Solution();
	ListNode l1 = sol.create(1, 1, 2, 3, 3);
	sol.print(l1);
	sol.print(sol.deleteDuplicates(l1));


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
