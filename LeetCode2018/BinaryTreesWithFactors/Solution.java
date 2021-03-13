import java.util.*;
class Solution {
    int MOD = (int)1e9 + 7;
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < n; i++){
            index.put(arr[i], i);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0;j < i; j++){
                if(arr[i] % arr[j] == 0){
                    int right = arr[i]/arr[j];
                    if(index.containsKey(right)){
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) %MOD;
                    }
                }
            }
        }
        long result = 0;
        for(long e : dp){
            result += e;
        }
        return (int) (result%MOD);
        
    }
}
