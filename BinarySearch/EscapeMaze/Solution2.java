import java.util.*;

class Solution {
    public int solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix[0][0] == 1 || matrix[m - 1][n - 1] == 1) return -1;
        Queue<int[]> queue = new LinkedList();
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];

                if (i == m - 1 && j == n - 1) {
                    return count;
                }
                for (int[] d : directions) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (0 <= x && x < m && 0 <= y && y < n && !visited[x][y] && matrix[x][y] == 0) {

                        queue.add(new int[]{x, y, count});
                        visited[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }
}