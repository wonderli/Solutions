import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxDepth = 0;
    TreeNode result = null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        getDepth(root, 0);
        return result;
    }
    
    private int getDepth(TreeNode root, int depth){
        if(root == null) return depth;
        int left = getDepth(root.left, depth +1);
        int right = getDepth(root.right, depth + 1);
        int currDepth = Math.max(left, right) - 1;
        maxDepth = Math.max(currDepth + 1, maxDepth);
        if(left == maxDepth && right == maxDepth) {
            result = root;
        }
        return currDepth + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}
