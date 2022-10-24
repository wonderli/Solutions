import java.util.*;
class Solution {
    int m;
    int n;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean first = true;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(first && grid[i][j] == 1){
                    dfs(grid, i, j);
                    first = false;
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == -1){
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                // visited[x][y] = true;
                for(int[] d : directions){
                    int p = x + d[0];
                    int q = y + d[1];
                    if(p >= 0 && p < m && q >= 0 && q < n && !visited[p][q]){
                        if(grid[p][q] == 1){
                            return count;
                        }
                        queue.add(new int[]{p, q});
                        visited[p][q] = true;
                    }
                }
            }
            count++;
        }
        return 0;
        
    }
    private void dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= m || j < 0 || j>= n || grid[i][j] != 1){
            return;
        }
        grid[i][j] = -1;
        for(int[] e : directions){
            int x = i + e[0];
            int y = j + e[1];
            dfs(grid, x, y);
        }
    }
}