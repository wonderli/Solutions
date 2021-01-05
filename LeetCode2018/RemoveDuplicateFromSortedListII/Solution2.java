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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        while(curr != null){
            while(curr.next != null && curr.val == curr.next.val){
                curr = curr.next;
            }
            if(prev.next == curr){
                prev = prev.next;
            }else{
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
