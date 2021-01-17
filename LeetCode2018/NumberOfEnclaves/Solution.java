import java.util.*;
class Solution {
    int m;
    int n;
    int[][] directions = {{-1, 0},{1, 0}, {0, -1}, {0, 1}};
    public int numEnclaves(int[][] A) {
        m = A.length;
        n = A[0].length;
        //print(A);
        //System.out.println();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || i == m-1 || j == 0|| j==n-1 && A[i][j] == 1){
                    dfs(A, i, j);
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(A[i][j] == 1){
                    count++;
                }
            }
        }
        // print(A);
        return count;
    }
    private void print(int[][] grid){
        for(int i = 0; i < m; i++){
            System.out.println(Arrays.toString(grid[i]));
        }
    }
    private void dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;
        
        grid[i][j] = 0;
        for(int[] d : directions){
            int x = i + d[0];
            int y = j + d[1];
            dfs(grid, x, y);
        }
    }
}