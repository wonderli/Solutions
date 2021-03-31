import java.util.*;
public class Solution{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(l1 != null || l2 != null){
            int a = (l1 != null) ? l1.val : Integer.MAX_VALUE;
            int b = (l2 != null) ? l2.val : Integer.MAX_VALUE;
            if(a < b){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        return dummy.next;
    }
    public static void print(ListNode r){
        while(r != null){
            System.out.print(r.val + "->");
            r = r.next;
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        print(sol.mergeTwoLists(a, b));
    }
}
