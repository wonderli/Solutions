import java.util.*;
public class Solution{
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.left = left;
        root.right = right;
        return root;
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
