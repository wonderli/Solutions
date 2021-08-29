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
    Map<Integer, Integer> map = new HashMap<>();
    
    public boolean checkEqualTree(TreeNode root) {
        if(root == null) return false;
        
        int total = helper(root);
        if(total == 0) return map.getOrDefault(total, 0) > 1;
        return total%2 == 0 && map.containsKey(total/2);
    }
    
    private int helper(TreeNode root){
        if(root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        int total = root.val + left + right;
        map.put(total, map.getOrDefault(total, 0) + 1);
        return total;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}