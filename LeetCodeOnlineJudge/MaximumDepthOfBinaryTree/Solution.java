//Given a binary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
public class Solution{
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int ret =  (leftDepth > rightDepth) ? leftDepth : rightDepth;
        return ret + 1;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
