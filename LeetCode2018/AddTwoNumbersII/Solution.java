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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = reverse(l1);
        ListNode p2 = reverse(l2);
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int c = 0;
        while(p1 != null || p2 != null){
            int a = p1 == null ? 0: p1.val;
            int b = p2 == null ? 0 :p2.val;
            int sum = a + b + c;
            c = sum / 10;
            sum = sum % 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next; 
        }
        if(c != 0){
            curr.next = new ListNode(c);
        }

        ListNode ret = reverse(dummy.next);
        return ret;
    }
    
    private void print(ListNode n){
        while(n != null){
            System.out.println(n.val);
            n = n.next;
        }
    }
    
    public ListNode reverse(ListNode head) {
        return helper(null, head);
    }
    
    private ListNode helper(ListNode prev, ListNode curr){
        if(curr == null){
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;
        return helper(curr, next);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
}
