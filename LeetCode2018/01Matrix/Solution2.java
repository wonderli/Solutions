import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return matrix;
        int n = matrix[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            for (int[] d : directions) {
                int x = i + d[0];
                int y = j + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (dist[x][y] > dist[i][j] + 1) {
                        dist[x][y] = dist[i][j] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        return dist;
    }
}