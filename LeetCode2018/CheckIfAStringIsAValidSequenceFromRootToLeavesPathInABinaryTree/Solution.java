import java.util.*;
public class Solution{
    boolean result = false;
    TreeNode r = null;
    public boolean isValidSequence(TreeNode root, int[] arr) {
    	r = root;
        helper(root, arr, 0);
        return result;
    }
    public void  helper(TreeNode root, int[] arr, int pos){
        if(result) return;
        if(root != null && root.val == arr[pos]) {
        	pos++;
        	if(pos == arr.length) {
        		result = root.left == null && root.right == null;
        		return;
        	} else {
        		helper(root.left, arr, pos);
        		helper(root.right, arr, pos);
        	}
        }
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        int[] arr = {8};
        System.out.println(sol.isValidSequence(root, arr));
        
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
