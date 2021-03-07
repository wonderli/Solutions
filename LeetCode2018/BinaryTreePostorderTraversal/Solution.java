import java.util.*;
class Solution{
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        helper(root, ret);
        return ret;
    }
    public void helper(TreeNode root, List<Integer> ret){
        if(root == null) return;
        helper(root.left, ret);
        helper(root.right, ret);
        ret.add(root.val);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}