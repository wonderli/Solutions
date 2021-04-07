import java.util.*;
class Solution {
    public int minOperations(int n) {
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = (2 * i) + 1;
            sum += arr[i];
        }
        int t = sum/n;
        int result = 0;
        for(int i = 0; i < n/2; i++){
            result += (t - arr[i]);
        }
        return result;
        
    }
}
