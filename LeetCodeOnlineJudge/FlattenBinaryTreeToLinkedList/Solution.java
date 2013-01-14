//Given a binary tree, flatten it to a linked list in-place. 
public class Solution{
    public void flatten(TreeNode root) {
        root = f(root);
    }
    public TreeNode f(TreeNode root){
        if(root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode leftTail = f(root.left);
        if(leftTail == null) leftTail = root;
        TreeNode rightTail = f(root.right);
        if(rightTail == null) rightTail = leftTail;
        root.left = null;
        root.right = left;
        leftTail.right = right;
        return rightTail;
    }

    public static void main(String args[]){

    }
    
}
