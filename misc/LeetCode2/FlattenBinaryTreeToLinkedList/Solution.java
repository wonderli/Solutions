import java.util.*;
public class Solution{
    public void flatten(TreeNode root) {
        if(root == null);
        helper(root);
    }
    public TreeNode helper(TreeNode root){
        if(root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode leftTail = helper(left);
        if(leftTail == null) leftTail = root;
        TreeNode rightTail = helper(right);
        if(rightTail == null) rightTail = leftTail;
        root.left = null;
        root.right = left;
        leftTail.right = right;
        return rightTail;
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
