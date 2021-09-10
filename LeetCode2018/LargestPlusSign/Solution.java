import java.util.*;
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for(int[] g : grid){
            Arrays.fill(g, n);
        }
        
        for(int[] m : mines){
            grid[m[0]][m[1]] = 0;
        }
        
        for(int i =0; i < n; i++){
            for(int j = 0, l = 0; j < n; j++){
                l = grid[i][j] == 0 ? 0 : l+1;
                grid[i][j] = Math.min(grid[i][j], l);
            }
            
            for(int j = n-1, r = 0; j>=0; j--){
                r = grid[i][j] == 0 ? 0 : r+1;
                grid[i][j] = Math.min(grid[i][j], r);
            }
            
            for(int j = 0, u = 0; j < n; j++){
                u = grid[j][i] == 0 ? 0 : u+1;
                grid[j][i] = Math.min(grid[j][i], u);
            }
            
            for(int j = n-1, d = 0; j >= 0; j--){
                d = grid[j][i] == 0 ? 0 : d+1;
                grid[j][i] = Math.min(grid[j][i], d);
            }
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                result = Math.max(grid[i][j], result);
            }
        }
        return result;
    }
}
