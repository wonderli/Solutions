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
    int sum = 0;
    int maxDepth = 0;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        return sum;
    }
    
    private void dfs(TreeNode root, int depth){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right ==null){
            if(depth > maxDepth){
                sum = root.val;
                maxDepth = depth;
            }else if(depth == maxDepth){
                sum += root.val;
            }
        }
        
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}
