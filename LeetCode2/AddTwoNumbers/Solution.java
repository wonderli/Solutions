import java.util.*;
public class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(l1 != null || l2 != null){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            p.next = new ListNode((a + b + carry)%10);
            carry = (a + b + carry)/10;
            p = p.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry != 0) p.next = new ListNode(carry);
        return dummy.next;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
