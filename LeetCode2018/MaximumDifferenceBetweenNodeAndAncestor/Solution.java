import java.util.*;
public class Solution{
    public int maxAncestorDiff(TreeNode root) {
        return helper(root,root.val, root.val);
    }
    private int helper(TreeNode root, int min, int max){
        if(root ==null) return max -min;
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        int left = helper(root.left, min, max);
        int right = helper(root.right, min, max);
        return Math.max(left, right);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
