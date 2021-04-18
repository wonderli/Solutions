import java.util.*;
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefix = new int[m+1][n+1];
        for(int i = 1; i <=m; i++){
            for(int j = 1; j <= n;j++){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        
        int curr = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= m; i++){
            for(int j = i; j <= m; j++){
                map.clear();
                map.put(0, 1);
                for(int k = 1; k <= n; k++){
                    curr = prefix[j][k] - prefix[i-1][k];
                    count += map.getOrDefault(curr - target, 0);
                    map.put(curr, map.getOrDefault(curr, 0) + 1);
                }
            }
        }
        return count;
    }
}
