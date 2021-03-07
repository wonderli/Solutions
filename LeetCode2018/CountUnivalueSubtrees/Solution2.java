import java.util.*;
class Solution{
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
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
