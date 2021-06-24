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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        ListNode prev = dummy;
        for(int i = 0; i < left; i++){
            prev = p1;
            p1 = p1.next;
        }
        
        for(int i = 0; i < right; i++){
            p2 = p2.next;
        }
        ListNode nNext = p2.next;
        ListNode curr = p1;
        ListNode currPrev = null;
        while(curr != nNext){
            ListNode next = curr.next;
            curr.next = currPrev;
            currPrev = curr;
            curr = next;
        }
        prev.next = p2;
        p1.next = nNext;
        return dummy.next;
        
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
}
