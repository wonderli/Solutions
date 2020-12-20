import java.util.*;
class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] cache = new int[m][n][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(grid, 0, 0, n- 1, cache);
    }
    private int dfs(int[][] grid, int i, int j, int k, int[][][] cache){
        if(j < 0 || j >= grid[0].length || k < 0 || k >= grid[0].length){
            return 0;
        }
        if(cache[i][j][k] != -1) return cache[i][j][k];
        
        int result = 0;
        result += grid[i][j];
        if(j != k){
            result += grid[i][k];
        }
        if(i != grid.length - 1){
            int max = 0;
            for(int q = j - 1; q <= j + 1; q++){
                for(int r = k - 1; r <= k + 1; r++){
                    max = Math.max(max, dfs(grid, i+1, q, r, cache));
                }
            }
            result += max;
        }
        cache[i][j][k] = result;
        return result;
    }
}