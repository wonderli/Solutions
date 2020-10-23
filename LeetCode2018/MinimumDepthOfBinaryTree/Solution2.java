import java.util.*;
public class Solution2{
    public int minDepth(TreeNode root) {
		if(root == null) return 0;
        return helper(root, 0);
    }
    public int helper(TreeNode root, int curr){
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null){
            return curr + 1;
        }
        int left = helper(root.left, curr+1);
        int right = helper(root.right, curr+1);
        return Math.min(left, right);
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
