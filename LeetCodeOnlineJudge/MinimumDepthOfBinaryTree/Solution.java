//Minimum Depth of Binary Tree
//
//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
public class Solution{
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right != null){
            return minDepth(root.right) + 1;
        }
        if(root.right == null && root.left != null){
            return minDepth(root.left) + 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        int ret = left < right ? left : right;
        return ret + 1;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
