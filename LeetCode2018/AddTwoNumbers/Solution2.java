import java.util.*;
public class Solution2{
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        return helper(l1, l2, 0);
//    }
//    public ListNode helper(ListNode l1, ListNode l2, int carry){
//        if(l1 == null && l2 == null){
//            if(carry != 0) {
//                return new ListNode(carry);
//            }else{
//                return null;
//            }
//        }
//
//        int v1 = l1 != null ? l1.val : 0;
//        int v2 = l2 != null ? l2.val : 0;
//        int res = (v1 + v2 + carry) % 10;
//        carry = (v1 + v2 + carry)/10;
//        ListNode ret = new ListNode(res);
//        ret.next = helper(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
//        return ret;
//    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curr = dummy;
        int carry = 0;
        while(p1 != null || p2 != null){
            int a = p1 != null ? p1.val : 0;
            int b = p2 != null ? p2.val : 0;
            int sum = (a + b + carry)%10;
            carry = (a + b+ carry)/10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            if(p1 != null){
                p1 = p1.next;
            }
            if(p2 != null){
                p2 = p2.next;
            }
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
