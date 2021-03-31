import java.util.*;
public class Solution{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        int len = len(head);
        if(len < n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        int i = 0;
        while(i <= n){
            p = p.next;
            i++;
        }
        while(p != null){
            p = p.next;
            q = q.next;
        }
        ListNode remove = (q != null) ? q.next : null;
        ListNode next = (remove != null) ? remove.next : null;
        q.next = next;
        return dummy.next;
    }
    public int len(ListNode root){
        int ret = 0;
        while(root != null){
            root = root.next;
            ret++;
        }
        return ret;
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
