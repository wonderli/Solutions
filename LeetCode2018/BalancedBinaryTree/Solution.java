import java.util.*;
public class Solution{
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(Math.abs(leftDepth - rightDepth) <= 1){
            return isBalanced(root.left) && isBalanced(root.right);
        }else{
            return false;
        }
    }
    private int maxDepth(TreeNode r){
        if(r == null) return 0;
            return Math.max(1 + maxDepth(r.left), 1 + maxDepth(r.right));
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode r = new TreeNode(1);
        r.left = null;
        r.right = new TreeNode(2);
        r.right.left = null;
        r.right.right = new TreeNode(3);
        System.out.println(sol.isBalanced(r));
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
