import java.util.*;
/**
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
*/

class Solution {
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		if(target == null || original == null || cloned == null) return null;
		if(target == original) return cloned;
		TreeNode left = getTargetCopy(original.left, cloned.left, target);
		if(left != null) return left;
		TreeNode right = getTargetCopy(original.right, cloned.right, target);
		return right;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {};
	TreeNode(int x) { val = x; }
}
