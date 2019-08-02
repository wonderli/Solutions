import java.util.*;
public class Solution{
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        int val = root.val;
        return helper(root, null, null);
    }
    public boolean helper(TreeNode root, Integer l, Integer r){
        if(root == null) return true;
        if(l != null &&  l >= root.val) return false;
        if(r != null && r <= root.val) return false; 
        return helper(root.left, l, root.val) && helper(root.right, root.val, r);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        System.out.println(sol.isValidBST(root));
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
