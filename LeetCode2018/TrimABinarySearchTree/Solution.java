import java.util.*;
public class Solution{
	public TreeNode trimBST(TreeNode root, int low, int high) {
	        if(root == null) return null;
	        if(root.val < low){
	            return trimBST(root.right, low, high);
	        }else if(root.val > high){
	            return trimBST(root.left, low, high);
	        }else{
	            root.left = trimBST(root.left, low, root.val);
	            root.right = trimBST(root.right, root.val, high);
	            return root;
	        }
	    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}