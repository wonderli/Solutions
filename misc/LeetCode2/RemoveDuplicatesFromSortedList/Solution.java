import java.util.*;
public class Solution{
    public ListNode deleteDuplicates(ListNode head){
        if(head == null) return null;
        ListNode prev = head;
        ListNode p = head.next;
        while(p != null){
            if(p.val == prev.val){
                p = p.next;
            }else{
                prev.next = p;
                prev = p;
                p = p.next;
            }
        }
        prev.next = p;
        return head;
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
