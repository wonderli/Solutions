import java.util.Arrays;
class Solution {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // print(grid);
        int[][] dp = new int[m+1][n+1];
        int count = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(grid[i-1][j-1] == 1){
                    for(int k = 1; k <  i; k++){
                        for(int p = 1; p < j; p++){
                            if(grid[i- 1 - k][j-1] == 1 && grid[i - 1- k][j - 1 - p] == 1 && grid[i-1][j - 1 - p] == 1){
                                dp[i][j]++;
                            }
                        }
                    }
                    count += dp[i][j];
                }
            }
        }
        // print(dp);
        // System.out.println(count);
        return count;
    }

    private void print(int[][] dp) {
        for(int[] e : dp){
            System.out.println(Arrays.toString(e));
        }
        System.out.println("==============");
    }

    public static void main(String[] args) {
         Solution sol = new Solution();
         //int[][] m = {{0,1,0},{1,0,1},{1,0,1},{0,1,0}};
        int[][] m = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};
         sol.countCornerRectangles(m);
      }
}