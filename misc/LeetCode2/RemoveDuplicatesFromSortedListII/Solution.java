import java.util.*;
public class Solution{
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        ListNode prev = dummy;
        while(p != null){
            boolean dup = false;
            while(p.next != null && p.val == p.next.val){
                dup = true;
                p = p.next;
            }
            if(dup == true){
                prev.next = p.next;
                p = p.next;
            }else {
                p = p.next;
                prev = prev.next;
            }
        }
        return dummy.next;
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
