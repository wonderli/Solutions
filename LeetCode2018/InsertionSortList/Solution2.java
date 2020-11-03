import java.util.*;
public class Solution2{
    ListNode dummy = new ListNode(0);

       public ListNode insertionSortList(ListNode head) {
           if(head == null) return null;
           dummy.next = head;
           helper(head, head.next);
           return dummy.next;
       }

       private void helper(ListNode prev, ListNode head) {
           if (head == null) return;
           ListNode next = head.next;

           ListNode n = dummy.next;

           ListNode p = dummy;
           while (n != null && n.val < head.val) {
               p = n;
               n = n.next;
           }

       

           if(p.next == head){
               helper(head, next);
           }else{
               p.next = head;
               head.next = n;
               prev.next = next;
               helper(prev, next);
           }
        
       }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
