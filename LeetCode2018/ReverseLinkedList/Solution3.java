import java.util.*;
public class Solution3{
        public ListNode reverseList(ListNode head) {
            return reverseList(head, null);
        }
        public ListNode reverseList(ListNode curr, ListNode prev){
            if(curr == null) return prev;
            ListNode next = curr.next;
            curr.next = prev;
            return reverseList(next, curr);
        }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
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
