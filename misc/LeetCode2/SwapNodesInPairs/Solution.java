import java.util.*;
public class Solution{
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;
        ListNode next = head.next;
        ListNode n = next.next;
        next.next = head;
        head.next = swapPairs(n);
        return next;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
