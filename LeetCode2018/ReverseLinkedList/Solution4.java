import java.util.*;
public class Solution4{
//    public ListNode reverseList(ListNode head) {
//        return reverse(head, null);
//    }
//    public ListNode reverse(ListNode curr, ListNode prev){
//        if(curr == null) return prev;
//        ListNode next = curr.next;
//        curr.next = prev;
//        return reverse(next, curr);
//    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String args[]){
        Solution4 sol = new Solution4();
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
