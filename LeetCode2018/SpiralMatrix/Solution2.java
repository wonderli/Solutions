import java.util.ArrayList;
import java.util.List;

class Solution2 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix.length == 0)
			return res;
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] seen = new boolean[row][col];
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int r = 0;
		int c = 0;
		int di = 0;
		for (int i = 0; i < row * col; i++) {
			res.add(matrix[r][c]);
			seen[r][c] = true;
			int currR = r + dr[di];
			int currC = c + dc[di];
			if (0 <= currR && currR < row && 0 <= currC && currC < col && !seen[currR][currC]) {
				r = currR;
				c = currC;
			} else {
				di = (di + 1) % 4;
				r += dr[di];
				c += dc[di];
			}
		}
		return res;

	}

}