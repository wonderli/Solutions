import java.util.*;

class Solution {
	int max = 1;

	public int longestConsecutive(TreeNode root) {
		if (root == null)
			return 0;
		helper(root, 1);
		return max;
	}

	public void helper(TreeNode node, int size) {
		if (node == null)
			return;
		max = Math.max(max, size);
		int val = node.val;

		if (node.left != null) {
			if (val + 1 == node.left.val) {
				helper(node.left, size + 1);
			} else {
				helper(node.left, 1);
			}
		}

		if (node.right != null) {
			if (val + 1 == node.right.val) {
				helper(node.right, size + 1);
			} else {
				helper(node.right, 1);
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		System.out.println(sol.longestConsecutive(node));
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
