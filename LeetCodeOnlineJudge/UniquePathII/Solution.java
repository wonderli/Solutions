//Follow up for "Unique Paths":
//
//Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//An obstacle and empty space is marked as 1 and 0 respectively in the grid.
public class Solution{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int f[][] = new int[m][n];
        if(obstacleGrid[0][0] != 1) f[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i != 0 && obstacleGrid[i-1][j] != 1){
                    f[i][j] += f[i-1][j];
                }
                if(j != 0 && obstacleGrid[i][j-1] != 1 ){
                    f[i][j] += f[i][j-1];
                }
            }
        }
        if(obstacleGrid[m-1][n-1] == 1) return 0;
        return f[m-1][n-1];
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
