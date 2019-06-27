import java.util.*;
public class Solution{
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while(node != null){
            ListNode next = node.next;
            if(next == null) break;
            node.val = next.val;
            prev = node;
            node = next;
        }
        prev.next = null;
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
