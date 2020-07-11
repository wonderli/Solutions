import java.util.*;
import java.math.*;

public class Solution {
	int min = Integer.MAX_VALUE;

	public int assignBikes(int[][] workers, int[][] bikes) {
		int m = workers.length;
		int n = bikes.length;
		boolean[] bikeVisited = new boolean[n];
		helper(0, workers, bikes, bikeVisited, 0);
		return min;
	}

	public void helper(int count, int[][] workers, int[][] bikes, boolean[] bikeVisited, int sum) {
		if (count >= workers.length) {
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < bikes.length; i++) {
			if (!bikeVisited[i]) {
				bikeVisited[i] = true;
				int distance = distance(workers[count], bikes[i]); 
				helper(count+ 1, workers, bikes, bikeVisited, sum + distance);
				bikeVisited[i] = false;
			}
		}
	}

	public int distance(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		int[][] w = { { 0, 0 }, { 1, 1 }, { 2, 0 } };
		int[][] b = { { 1, 0 }, { 2, 2 }, { 2, 1 } };
		// int[][] w = {{0, 0}, {2, 1}};
		// int[][] b = {{1, 2}, {3, 3}};
		System.out.println(sol.assignBikes(w, b));
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
