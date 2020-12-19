import java.util.*;

public class Solution {
	int row;
	int col;
	char[] w;

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0)
			return false;
		row = board.length;
		col = board[0].length;
		w = word.toCharArray();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				boolean[][] visited = new boolean[row][col];
				if (helper(i, j, board, visited, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean helper(int i, int j, char[][] board, boolean[][] visited, int index) {
		if (i < 0 || j < 0 || i >= row || j >= col)
			return false;
		if (visited[i][j])
			return false;
		char curr = board[i][j];
		if (index == w.length - 1 && curr == w[index]) {
			return true;
		}
		if (curr != w[index])
			return false;
		visited[i][j] = true;
		if (helper(i - 1, j, board, visited, index + 1))
			return true;
		if (helper(i + 1, j, board, visited, index + 1))
			return true;

		if (helper(i, j - 1, board, visited, index + 1))
			return true;
		if (helper(i, j + 1, board, visited, index + 1))
			return true;
		
		visited[i][j] = false;
		return false;

	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		System.out.println(sol.exist(board, word));
	}
}
