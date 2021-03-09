import java.util.*;
class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode p1 = head;
        ListNode p2 = head.next != null ? head.next.next : null;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2 != null ? (p2.next != null ? p2.next.next : null) : null;
        }
        return p1 == p2 && p1 != null;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}