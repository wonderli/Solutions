import java.util.*;

/**
 * 
 * (y - y1) / (x - x1) = (y1 - y0) / (x1 - x0)
 * 
 * 
 * (x - x1) * (y1 - y0) = (y - y1) * (x1 - x0)
 * 
 */
public class Solution {
	public boolean checkStraightLine(int[][] coordinates) {
		int x0 = coordinates[0][0];
		int y0 = coordinates[0][1];

		int x1 = coordinates[1][0];
		int y1 = coordinates[1][1];

		for (int i = 2; i < coordinates.length; i++) {
			int currX = coordinates[i][0];
			int currY = coordinates[i][1];

			if ((currX - x1) * (y1 - y0) != (currY - y1) * (x1 - x0)) {
				return false;
			}

		}
		return true;
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		int[][] arr = { { 0, 0 }, { 0, 1 }, { 0, -1 } };
		System.out.println(sol.checkStraightLine(arr));
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
