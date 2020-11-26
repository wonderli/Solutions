import java.util.*;
public class Solution2{
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        TreeNode left = root.left;
        left.left = root.right;
        left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
