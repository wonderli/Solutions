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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        for(int i = 0; i < m - 1; i++){
            prev = prev.next;
        }
        ListNode mNode = prev.next;
        ListNode then = mNode.next;
        for(int i = 0; i < n - m; i++){
            mNode.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = mNode.next;
        }
        return dummy.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
}