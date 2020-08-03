import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return new ArrayList<Integer>();

		int r = matrix.length;
		int c = matrix[0].length;
		return helper(matrix, 0, 0, r, c);
	}

	public List<Integer> helper(int[][] matrix, int r, int c, int row, int col) {
		List<Integer> res = new ArrayList<>();
		if (row <= 0 || col <= 0)
			return res;
		for (int j = c; j < c + col; j++) {
			res.add(matrix[r][j]);
		}
		for (int i = r + 1; i < r + row - 1; i++) {
			res.add(matrix[i][c + col - 1]);
		}
		if (row > 1) {
			for (int j = c + col - 1; j >= c; j--) {
				res.add(matrix[c + row - 1][j]);
			}
		}
		if (col > 1) {
			for (int i = r + row - 2; i > r; i--) {
				res.add(matrix[i][c]);
			}
		}
		res.addAll(helper(matrix, r + 1, c + 1, row - 2, col - 2));
		return res;
	}

}