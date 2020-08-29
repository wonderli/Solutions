import java.util.*;
public class Solution2{
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }
    public boolean helper(TreeNode root){
        if(root == null) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if(left && right){
            if(root.left != null && root.left.val != root.val){
                return false;
            }
            if(root.right != null && root.right.val != root.val){
                return false;
            }
            count++;
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
