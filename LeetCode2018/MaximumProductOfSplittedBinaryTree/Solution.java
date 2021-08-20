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
    Map<TreeNode, Long> map = new HashMap<>();
    long mod = (long) (1e9+7);
    
    public int maxProduct(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        long max = 0;
        long total = map.get(root);
        for(TreeNode node : map.keySet()){
            long sum = map.get(node);
            max= Math.max(max, ((total - sum) * sum));
        }
        return (int)(max % mod);
    }
    
    private long helper(TreeNode root){
        if(root == null){
            return 0;
        }
        long left = helper(root.left);
        long right = helper(root.right);
        long sum = (left + right + root.val);
        map.put(root, sum);
        return sum;
        
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}