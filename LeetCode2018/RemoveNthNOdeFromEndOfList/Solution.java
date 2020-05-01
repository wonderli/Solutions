import java.util.*;
public class Solution{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        ListNode nth = head;
        for(int i = 0; i < n; i++){
            nth = nth.next;
        }
        ListNode original = new ListNode(0);
        ListNode curr = head;
        original.next = head;

        ListNode pre = original;
        while(nth != null){
            pre = curr;
            curr = curr.next;
            nth = nth.next;
        }
        pre.next = curr.next;
        return original.next;
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
