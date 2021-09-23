import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestDistance(int[][] grid) {

        int min = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        int totalHouses = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    totalHouses++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    min = Math.min(min, bfs(grid, i, j, totalHouses));
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    private int bfs(int[][] grid, int r, int c, int totalHouses) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        boolean[][] visited = new boolean[m][n];
        visited[r][c] = true;
        int dist = 0;
        int housesReached = 0;
        int steps = 0;
        while (!queue.isEmpty() && housesReached != totalHouses) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                if (grid[x][y] == 1) {
                    dist += steps;
                    housesReached++;
                    continue;
                }
                for (int[] d : directions) {
                    int x1 = x + d[0];
                    int y1 = y + d[1];
                    if (0 <= x1 && x1 < m && 0 <= y1 && y1 < n) {
                        if (!visited[x1][y1] && grid[x1][y1] != 2) {
                            visited[x1][y1] = true;
                            queue.add(new int[]{x1, y1});
                        }
                    }
                }
            }
            steps++;
        }

        if (housesReached != totalHouses) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0 && visited[i][j]) {
                        grid[i][j] = 2;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }
        return dist;
    }
}