import java.util.*;
public class Solution3{
    int count = 0;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        count--;
        if(count == 0){
            res = root.val;
            return;
        }
        helper(root.right);
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
