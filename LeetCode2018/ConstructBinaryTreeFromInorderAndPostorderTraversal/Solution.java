import java.util.*;
public class Solution{
    int ind;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null && inorder == null) return null;
        if(postorder.length == 0 && inorder.length == 0) return null;
        ind = postorder.length - 1;
        return helper(inorder, 0, inorder.length - 1, postorder);
    }
    public TreeNode helper(int[] inorder, int start, int end, int[] postorder){
        if(start > end) return null;
        TreeNode root = new TreeNode(postorder[ind]);
        int mid = find(inorder, start, end, postorder[ind]);
        ind--;
        TreeNode right = helper(inorder, mid + 1, end, postorder);
        TreeNode left = helper(inorder, start, mid - 1, postorder);
        root.left = left;
        root.right = right;
        return root;
    }
    public int find(int[] inorder, int start, int end, int val){
        for(int i = start; i <= end; i++){
            if(inorder[i] == val) return i;
        }
        return -1;
    }
    public void print(TreeNode root){
        if(root == null) return;
        print(root.left);
        System.out.print(root.val + "->");
        print(root.right);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = sol.buildTree(inorder, postorder);
        sol.print(root);
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
