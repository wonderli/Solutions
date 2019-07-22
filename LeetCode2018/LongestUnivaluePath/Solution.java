import java.util.*;
public class Solution{
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        longestPath(root);
        return ans;
    }
    public int longestPath(TreeNode root){
        if(root == null) return 0;
        int left = longestPath(root.left);
        int right = longestPath(root.right);
        int arrowLeft = 0;
        int arrowRight = 0;
        if(root.left != null && root.left.val == root.val){
            arrowLeft += left + 1;
        }
        if(root.right != null && root.right.val == root.val){
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(2);
        // root.left.left = new TreeNode(2);
        // root.left.right = new TreeNode(2);
        // root.right.left = new TreeNode(2);
        // root.right.right = new TreeNode(2);
        // System.out.println(sol.longestUnivaluePath(root));
		
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.left.left = new TreeNode(1);
		root.right.left.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
		root.right.right.right = new TreeNode(1);
		System.out.println(sol.longestUnivaluePath(root));
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
