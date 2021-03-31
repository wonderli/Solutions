import java.util.*;
public class Solution{
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean helper(TreeNode root, int min, int max){
        if(root == null) return true;
        if(root.val > min && root.val < max){
            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        }
        return false;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
