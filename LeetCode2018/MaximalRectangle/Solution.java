import java.util.*;
class Solution {
    int m;
    int n;
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] grid = new int[m][n];
        buildHistogram(matrix, grid);
        int max = 0;
        for(int i = 0; i < m; i++){
            max = Math.max(max, maxRect(grid, i));
        }
        return max;
    }
    private void buildHistogram(char[][] matrix, int[][] grid){
        for(int j = 0; j < n; j++){
            grid[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = matrix[i][j] == '1' ? grid[i-1][j] + 1: 0;
            }
        }
        
    }
    
    
    private int maxRect(int[][] grid, int i){
        int[] row = grid[i];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0;
        for(int j = 0; j < n; j++){
            while(stack.peek() != -1 && row[j] <= row[stack.peek()]){
                max = Math.max(max, row[stack.pop()] * (j - stack.peek() - 1));
            }
            stack.push(j);
        }
        while(stack.peek() != -1){
            max = Math.max(max, row[stack.pop()] * (n - stack.peek() - 1));
        }
        return max;
    }
    
}