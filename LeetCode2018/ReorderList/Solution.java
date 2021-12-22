import java.util.*;
class Solution {
    ListNode p;
    boolean isStop;
    public void reorderList(ListNode head) {
        p = head;
        isStop = false;
        helper(head);
    }
    
    private void helper(ListNode head){
        if(head == null) {
            return;
        }
        
        helper(head.next);
        if(!isStop){
            ListNode next = p.next;
            p.next = head;
            head.next = next;
            p = next;
        }
        
        // Reach to end
        if(p != null && p.next == head){
            p.next = null;
            isStop = true;
        }
        
    }
    
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
}