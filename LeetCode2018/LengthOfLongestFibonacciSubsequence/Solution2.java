import java.util.*;
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        if(n < 3) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int result = 2;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], 2);
        }
        for(int i = 0; i < n; i++){
            map.put(arr[i], i);
            if(i < 2) continue;
            for(int j = i - 1; j >= 0; j--){
                if(map.getOrDefault(arr[i] - arr[j], -1) >= 0 && arr[i] - arr[j] < arr[j]){
                    dp[i][j] = 1 + dp[j][map.get(arr[i] - arr[j])];
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result > 2 ? result : 0;
    }
}
