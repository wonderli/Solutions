import java.util.*;
class Solution {
    int mod = (int)1e9 + 7;
    int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int m;
    int n;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        Integer[][][] dp = new Integer[m][n][maxMove+1];
        return helper(startRow, startColumn, maxMove, dp);
    }
    
    private int helper(int i, int j, int maxMove, Integer[][][] dp){
        if(i < 0 || j < 0 || i == m || j== n){
            return 1;
        }
        if(maxMove == 0) return 0;
        if(dp[i][j][maxMove] != null) return dp[i][j][maxMove];
        
        int curr = 0;
        for(int[] d : directions){
            int x = i + d[0];
            int y = j + d[1];
            curr += helper(x, y, maxMove - 1, dp);
            curr = curr % mod;
        }
        dp[i][j][maxMove] = curr % mod;
        return dp[i][j][maxMove];
    }
}
