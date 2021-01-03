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
		TreeNode right = getTargetCopy(original.right, cloned.right, target);
		if(left == null) return right;
		else return left;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {};
	TreeNode(int x) { val = x; }
}