import java.util.*;
public class Solution{
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);
		root.right = left;
		root.left = right;
		return root;
	}
	public static void main(String args[]){
		Solution sol = new Solution();
	}
}
