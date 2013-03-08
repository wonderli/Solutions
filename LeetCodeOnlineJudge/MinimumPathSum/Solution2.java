//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//You can only move either down or right at any point in time.
public class Solution2{
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i =  0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                if(i == 0 && j > 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j]; 
                }
                if(j == 0 && i > 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
                if(i > 0 && j > 0){
                    dp[i][j] = Math.min(dp[i][j-1] + grid[i][j], dp[i-1][j] + grid[i][j]);
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int grid[][] = {{1, 3, 1}, {1, 5, 1}, {1, 2, 1}};
        System.out.println(sol.minPathSum(grid));
    }
}
