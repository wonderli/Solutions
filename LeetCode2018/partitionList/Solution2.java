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
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode r1 = l1;
        ListNode r2 = l2;
        while(head != null){
            if(head.val < x){
                r1.next = head;
                r1 = r1.next;
            }else{
                r2.next = head;
                r2 = r2.next;
            }
            head = head.next;
        }
        r2.next = null;
        r1.next =l2.next;
        return l1.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
}