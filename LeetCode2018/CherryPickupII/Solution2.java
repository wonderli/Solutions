import java.util.*;
public class Solution2{
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        for(int i = m - 1; i >= 0; i--){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    int result = grid[i][j];
                    if(j != k){
                        result += grid[i][k];
                    }
                    if(i != m - 1){
                        int max = 0;
                        for(int p = j - 1; p <= j+1; p++){
                            for(int q = k - 1; q <= k+1; q++){
                                if(p >= 0 && p < n && q >= 0 && q < n){
                                    max = Math.max(max, dp[i+1][p][q]);
                                }
                            }
                        }
                        result += max;
                    }
                    dp[i][j][k] = result;
                }
            }
        }
        return dp[0][0][n-1];
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
