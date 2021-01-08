import java.util.*;
class Solution {
    public int islandPerimeter(int[][] grid) {
         int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int result  = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    queue.add(new int[]{i, j});
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        for(int k = 0; k < size; k++){
                            int[] curr = queue.poll();
                            int row = curr[0];
                            int col = curr[1];
                            grid[row][col] = 2;
                            result += helper(grid, row -1, col, queue) + helper(grid, row + 1, col, queue) + helper(grid, row, col - 1, queue) + helper(grid, row, col + 1, queue);
                        }
                    }
                }
            }
        }
        return result;
    }
    private int helper(int[][] grid, int row, int col, Queue<int[]> queue){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return 1;
        }
        if(grid[row][col] == 0) return 1;
        if(grid[row][col] == 1){
            grid[row][col] = 2;
            queue.add(new int[]{row, col});
            return 0;
        }
        return 0;
    }
}