import java.util.*;
class Solution{
    int count = 0;
    public int countUnivalSubtrees(TreeNode root){
        if(root == null) return 0;
        helper(root);
        return count;
    }
    public boolean helper(TreeNode root){
        if(root == null) return true;
        if(root.left == null && root.right == null){
            count++;
            return true;
        }
        boolean isUnival = true;
        if(root.left != null){
            isUnival = helper(root.left) && isUnival && root.left.val == root.val;
        }
        if(root.right != null){
            isUnival = helper(root.right) && isUnival && root.right.val == root.val;
        }
        if(!isUnival) return false;
        count++;
        return true;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
