import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }
    public ListNode add(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null){
            if(carry != 0){
                return new ListNode(carry);
            }else{
                return null;
            }
        }
        ListNode ret = new ListNode(0);
        int v1 = l1 != null ? l1.val : 0;
        int v2 = l2 != null ? l2.val : 0;
        ret.val = (v1 + v2 + carry)%10;
        carry = (v1 + v2 + carry)/10;
        ret.next = add(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);
        return ret;
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
