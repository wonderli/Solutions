import java.util.*;
class Solution {
    int m;
    int n;
    int[] directions = {-1, 0, 1};

    public int minFallingPathSum(int[][] A) {
        m = A.length;
        n = A[0].length;
        Integer[][] cache = new Integer[m][n];
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dfs(A, 0, j, cache));
        }
        return min;
    }

    private int dfs(int[][] A, int i, int j, Integer[][] cache) {
        if (i >= m) return 0;
        if (cache[i][j] != null) {
            return cache[i][j];
        }
        
        int min = Integer.MAX_VALUE;
        for (int d : directions) {
            int y = j + d;
            if (y >= 0 && y < n) {
                min = Math.min(min, dfs(A, i + 1, y, cache));
            }
        }


        cache[i][j] = min + A[i][j];

        return cache[i][j];
    }
}