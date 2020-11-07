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
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> s2 = new Stack<>();
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode prev = null;
        ListNode curr = null;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int a = s1.isEmpty() ? 0: s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int sum = (a + b + carry)%10;
            carry = (a + b +carry)/10;
            prev = curr;
            curr = new ListNode(sum);
            curr.next = prev;
        }
        if(carry != 0){
            prev = curr;
            curr = new ListNode(carry);
            curr.next = prev;
        }
        return curr;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
