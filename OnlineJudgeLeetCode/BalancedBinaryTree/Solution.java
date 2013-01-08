//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
public class Solution{
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if((Math.abs(height(root.left) - height(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }else return false;
    }
    public int height(TreeNode root){
        if(root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return leftHeight >= rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
    public static void main(String args[]){

    }
}
