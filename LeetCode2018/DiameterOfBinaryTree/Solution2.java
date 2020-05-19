import java.util.*;
public class Solution2{
    private int result = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root){
        helper(root);
        return Math.max(result, 0);
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = helper(root.left);
        int right = helper(root.right);
        result = Math.max(left + right, result);
        return 1 + Math.max(left, right);
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
