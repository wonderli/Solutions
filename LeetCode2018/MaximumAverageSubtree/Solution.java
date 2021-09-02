import java.util.*;
class Solution {
    double result = Double.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return result;
    }
    
    private double[] helper(TreeNode root){
        if(root ==null) return new double[]{0, 0};
        double left[] = helper(root.left);
        double right[] = helper(root.right);
        double total = left[0] + right[0] + root.val;
        double num = left[1] + right[1] + 1;
        result = Math.max(result, total/num);
        return new double[]{total, num};
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}

