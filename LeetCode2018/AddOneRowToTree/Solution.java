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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        insert(root, v, 1, d);
        return root;
    }
    
    private void insert(TreeNode root, int v, int curr, int d){
        if(root == null){
            return;
        }else if(curr == d-1){
            TreeNode left = root.left;
            root.left = new TreeNode(v);
            root.left.left = left;
            
            TreeNode right = root.right;
            root.right = new TreeNode(v);
            root.right.right = right;
        }else{
            insert(root.left, v, curr+1, d);
            insert(root.right, v, curr+1, d);
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}