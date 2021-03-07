import java.util.*;
class Solution{
    public TreeNode upsideDownBinaryTree(TreeNode root){
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode tmp = null;
        TreeNode prev = null;
        while(curr != null){
            next = curr.left;
            curr.left = tmp;
            tmp = curr.right;
            curr.right = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
