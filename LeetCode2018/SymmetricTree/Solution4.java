import java.util.*;
public class Solution4{
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null && right != null) return false;
        if(right == null && left != null) return false;
        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }
    public static void main(String args[]){
        Solution4 sol = new Solution4();
        TreeNode node = new TreeNode(1);
        TreeNode p = node;
        p.left = new TreeNode(2);
        p.right = new TreeNode(2);
        p.left.left = null;
        p.left.right = new TreeNode(3);
        p.right.left = null;
        p.right.right = new TreeNode(3);
        System.out.println(sol.isSymmetric(p));
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
