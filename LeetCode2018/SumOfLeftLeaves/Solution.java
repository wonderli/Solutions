import java.util.*;
public class Solution{
    private TreeNode prev = null;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(prev != null && prev.left == root && root.left ==null && root.right == null){
            return root.val;
        }
        prev = root;
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        System.out.println(sol.sumOfLeftLeaves(node));
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
