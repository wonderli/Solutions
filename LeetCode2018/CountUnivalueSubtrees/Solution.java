import java.util.*;
public class Solution{
    int[] count = new int[1];

    public int countUnivalSubtrees(TreeNode root) {
        helper(root, count);
        return count[0];
    }
    public boolean helper(TreeNode root, int[] count){
        if(root == null) return true;
        boolean left = helper(root.left, count);
        boolean right = helper(root.right, count);
        if(left && right){
            if(root.left != null && root.left.val != root.val){
                return false;
            }
            if(root.right != null && root.right.val != root.val){
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(sol.countUnivalSubtrees(root));
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
