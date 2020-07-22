import java.util.*;

public class Solution {
	public int findPairs(int[] nums, int k) {
		Arrays.sort(nums);
		int i = 0;
		int j = 1;
		int count = 0;
		while (i < nums.length && j < nums.length) {
			if (i == j || nums[j] - nums[i] < k) {
				j++;
			} else if (nums[j] - nums[i] > k) {
				i++;
			} else {
				i++;
				count++;
				while (i < nums.length && nums[i] == nums[i - 1]) {
					i++;
				}
			}

		}
		return count;
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		int[] a = { 3, 1, 4, 1, 5 };
		System.out.println(sol.findPairs(a, 2));
		int[] b = { 1, 2, 3, 4, 5 };
		System.out.println(sol.findPairs(b, 1));
		int[] c = { 1, 3, 1, 5, 4 };
		System.out.println(sol.findPairs(c, 0));
		int[] d = { 1, 1, 1, 1, 1 };
		System.out.println(sol.findPairs(d, 0));
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
