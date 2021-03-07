import java.util.*;
class Solution {
    int m;
    int n;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Integer[][] cache = new Integer[m][n];
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(grid, i, j, cache));
                }
            }
        }
        return max;
    }
    private int dfs(int[][] grid, int i, int j, Integer[][] cache){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return 0;
        if(cache[i][j] != null){
            return cache[i][j];
        }
        int result = 0;
        grid[i][j] = -1;
        for(int[] d : directions){
            int x = i + d[0];
            int y = j + d[1];
            result += dfs(grid, x, y, cache);
        }
        cache[i][j] =result +1 ;
        return cache[i][j];
    }
}