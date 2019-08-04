import java.util.*;
public class Solution{
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        TreeNode curr = root;
        helper(curr);
        return root;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        if(!containsOne(root.left)){
            root.left = null;
        }
        if(!containsOne(root.right)){
            root.right = null;
        }
        helper(root.left);
        helper(root.right);

    }
    public boolean containsOne(TreeNode root){
        if(root == null) return false;
        int val = root.val;
        boolean left = containsOne(root.left);
        boolean right = containsOne(root.right);
        return left || right || val == 1;
    }
    public void print(TreeNode node){
        if(node == null) return;
        print(node.left);
        System.out.print(node.val + ",");
        print(node.right);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        TreeNode res = sol.pruneTree(root);
        sol.print(res);
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
