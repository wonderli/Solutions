import java.util.*;

public class Solution {
	public int numTilePossibilities(String tiles) {
		char[] arr = tiles.toCharArray();
		String curr = new String();
		Set<String> result = new HashSet<>();
		boolean[] visited = new boolean[arr.length];

		dfs(arr, curr, result, visited);

		return result.size();
	}

	public void dfs(char[] arr, String curr, Set<String> result, boolean[] visited) {
		if (curr.length() > 0) {
			result.add(curr);
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(arr, curr + arr[i], result, visited);
				visited[i] = false;
			}
		}
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		System.out.println(sol.numTilePossibilities("AAB"));
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
