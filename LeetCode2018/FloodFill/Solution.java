import java.util.*;

public class Solution {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		Queue<Node> q = new LinkedList<>();
		Node root = new Node(sr, sc, image[sr][sc], newColor);
		q.add(root);
		image[sr][sc] = newColor;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node n = q.poll();
				int oldColor = n.oldColor;
				color(image, n);
				int x = n.x;
				int y = n.y;
				if (x > 0) {
					if (image[x - 1][y] != newColor && image[x - 1][y] == oldColor) {
						Node up = new Node(x - 1, y, oldColor, newColor);
						q.add(up);
					}
				}

				if (x < image.length - 1) {
					if (image[x + 1][y] != newColor && image[x + 1][y] == oldColor) {
						Node down = new Node(x + 1, y, oldColor, newColor);
						q.add(down);
					}
				}
				if (y > 0) {
					if (image[x][y - 1] != newColor && image[x][y - 1] == oldColor) {
						Node left = new Node(x, y - 1, oldColor, newColor);
						q.add(left);
					}
				}
				if (y < image[0].length - 1) {
					if (image[x][y + 1] != newColor && image[x][y + 1] == oldColor) {
						Node right = new Node(x, y + 1, oldColor, newColor);
						q.add(right);
					}
				}
			}
		}
		return image;
	}

	public void color(int[][] image, Node n) {
		int x = n.x;
		int y = n.y;
		int newColor = n.newColor;
		image[x][y] = newColor;
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		int[][] image = { { 0, 0, 0 }, { 0, 1, 1 } };
		int[][] res = sol.floodFill(image, 1, 1, 1);
		sol.print(res);
	}

	public void print(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	class Node {
		int x;
		int y;
		int oldColor;
		int newColor;

		public Node(int x, int y, int oldColor, int newColor) {
			this.x = x;
			this.y = y;
			this.oldColor = oldColor;
			this.newColor = newColor;
		}
	}
}
