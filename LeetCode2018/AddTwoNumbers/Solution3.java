import java.util.*;
public class Solution3{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        int carry = 0;
        ListNode curr = head;
        while(l1 != null || l2 != null){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int c = (a + b + carry)%10;
            carry = (a + b + carry)/10;
            curr.next = new ListNode(c);
            curr = curr.next;
            l1 = l1!= null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry != 0){
            curr.next = new ListNode(carry);
        }
        return head.next;

    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(){
    }
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
