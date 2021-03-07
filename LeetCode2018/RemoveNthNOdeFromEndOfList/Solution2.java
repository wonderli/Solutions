import java.util.*;
public class Solution2{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i = 0; i < n; i++){
            p2 = p2.next;
        }
        while(p2 != null){
            prev = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode next = p1.next;
        prev.next = next;
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
