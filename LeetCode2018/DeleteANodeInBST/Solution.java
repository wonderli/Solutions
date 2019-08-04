import java.util.*;
public class Solution{
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else {
            if(root.right == null){
                return root.left;
            }else if(root.left == null){
                return root.right;
            }
            TreeNode min = findMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }
        return root;
    }
    public TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
	public void print(TreeNode root) {
	    	if(root == null) {
	    		System.out.print("null, ");
	    		return;
	    	}
	    	print(root.left);
	    	System.out.print(root.val + ", ");
	    	print(root.right);
	    }
	public static void main(String args[]){
	        Solution sol = new Solution();
	        TreeNode root = new TreeNode(5);
	        root.left = new TreeNode(3); 
	        root.right = new TreeNode(6);
	        root.left.left = new TreeNode(2);
	        root.left.right = new TreeNode(4);
	        root.right.right = new TreeNode(7);
	        sol.deleteNode(root, 3);
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
