import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            return findLeftMost(p.right);
        }   
        TreeNode parentLeft = null;
        while (root != null) {
            if (root.val == p.val) {
                return parentLeft;
            } else if (root.val > p.val) {
                parentLeft = root;
                root = root.left;
            } else {
                root = root.right;
            }
         }
        return null;
    }
    private TreeNode findLeftMost(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}
