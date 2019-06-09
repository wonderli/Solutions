import java.util.*;
public class Solution{
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode prev = root;
        ListNode curr = head;
        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            }
            prev = prev.next;
            curr = curr.next;

        }
        return root.next;
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
