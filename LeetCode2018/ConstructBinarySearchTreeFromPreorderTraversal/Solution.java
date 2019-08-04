import java.util.*;
public class Solution{
    public TreeNode bstFromPreorder(int[] preorder){
        if(preorder == null || preorder.length == 0) return null;
        TreeNode root = helper(preorder, 0, preorder.length-1);
        return root;
    }
    public TreeNode helper(int[] preorder, int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int index = start + 1;
        while(index <= end && preorder[index] < preorder[start]) {
        	index++;
        }
        root.left = helper(preorder, start + 1, index-1);
        root.right = helper(preorder, index, end);
        return root;
    }
    public void print(TreeNode root){
        if (root == null) {
            System.out.print("null,");
            return;
        }
        print(root.left);
        System.out.print(root.val+",");
        print(root.right);
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        int[] pre = {4, 2};
        TreeNode root = sol.bstFromPreorder(pre);
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
