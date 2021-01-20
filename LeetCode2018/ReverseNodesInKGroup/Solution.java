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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        ListNode last = head;
        int count = 0;
        while(count < k && p2.next != null){
            p2 = p2.next;
            count++;
        }
        if(count < k){
            return dummy.next;
        }
        ListNode nextStart = null;
        if(p2 != null){
            nextStart = p2.next;
        }
        while(p1 != nextStart){
            ListNode t = p1.next;
            p1.next = prev;
            prev = p1;
            p1 = t;
        }
        dummy.next = p2;
        last.next = reverseKGroup(nextStart, k);
        return dummy.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
}
