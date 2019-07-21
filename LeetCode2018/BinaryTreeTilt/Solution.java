import java.util.*;
public class Solution{
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        int val = Math.abs(right - left);
        return val + findTilt(root.left) + findTilt(root.right);
    }
    public int sum(TreeNode node){
        if(node == null) return 0;
        int a = node.val;
        return a + sum(node.left) + sum(node.right);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        System.out.println(sol.findTilt(root));
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
