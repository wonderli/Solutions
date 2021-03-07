import java.util.*;
class Solution{
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValidBST(root, null, null);
    }
    public boolean isValidBST(TreeNode root, Integer left, Integer right){
        if(root == null) return true;
        if(left != null && left >= root.val) return false;
        if(right != null && right <= root.val) return false;
        return isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
