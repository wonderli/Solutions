import java.util.*;
class Solution {
    public int smallestRangeII(int[] A, int K) {
        int n = A.length;
        Arrays.sort(A);
        int min = A[n-1] - A[0];
        for(int i = 0; i < n - 1; i++){
            int high = Math.max(A[n-1] - K, A[i] + K);
            int low = Math.min(A[0] + K, A[i+1] - K);
            min = Math.min(min, high - low);
        }
        return min;
    }
}