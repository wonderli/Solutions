//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
public class Solution{
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    public boolean check(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        if((a == null && b != null)||(a != null && b == null)){
            return false;
        }
        if(a.val != b.val) return false;
        else
        return check(a.left, b.right) && check(a.right, b.left);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
