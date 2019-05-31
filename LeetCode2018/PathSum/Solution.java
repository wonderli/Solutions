import java.util.*;
public class Solution{
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root != null && root.left == null && root.right == null && sum == root.val) return true;
        return hasPathSum(root.left, sum - root.val) ||  hasPathSum(root.right, sum - root.val);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
