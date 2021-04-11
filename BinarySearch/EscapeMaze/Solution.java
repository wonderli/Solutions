import java.util.*;

class Solution {
    public int solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix[0][0] == 1 || matrix[m-1][n-1] == 1)return -1;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->(a[2] - b[2]));
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 1;
        queue.add(new int[]{0, 0, 1});
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            int cost = curr[2];
            visited[i][j] = true;
            if(i == m - 1 && j == n- 1){
                return cost;
            }
            for(int[] d : directions){
                int x = i + d[0];
                int y = j + d[1];
                if(0 <= x && x < m && 0<= y && y < n && !visited[x][y] && matrix[x][y] == 0){
                    if(dist[i][j] + 1 < dist[x][y]){
                        queue.add(new int[]{x, y, cost + 1});
                        dist[x][y] = dist[i][j] + 1;
                    }
                }
            }

        }
        return -1;
    }
}