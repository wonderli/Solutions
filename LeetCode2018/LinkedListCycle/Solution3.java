import java.util.*;
public class Solution3{
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while(p1 != null && p2 != null){
            p1 = p1.next;
            if(p2.next == null) return false;
            p2 = p2.next.next;
            if(p1 == p2) return true;
        }
        return false;
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
