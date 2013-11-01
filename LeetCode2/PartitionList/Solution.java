import java.util.*;
public class Solution{
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode p = dummy1;
        ListNode q = dummy2;
        while(head != null){
            if(head.val < x){
                p.next = new ListNode(head.val);
                p = p.next;
            }else{
                q.next = new ListNode(head.val);
                q = q.next;
            }
            head = head.next;
        }
        p.next = dummy2.next;
        return dummy1.next;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
