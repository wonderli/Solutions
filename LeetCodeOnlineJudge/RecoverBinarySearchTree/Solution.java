// Two elements of a binary search tree (BST) are swapped by mistake.
//
// Recover the tree without changing its structure. 
public class Solution{
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root){
        prev = null;
        first = null;
        second = null;
        helper(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if((prev != null) && (prev.val > root.val)){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        helper(root.right);
    }


    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode r = new TreeNode(0);
        r.right = new TreeNode(1);
        sol.recoverTree(r);
    }
}
