import java.util.*;
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < n; i++){
            index.put(arr[i], i);
        }
        Map<Integer, Integer> longest = new HashMap<>();
        int result = 0;
        for(int k = 0; k < n; k++){
            for(int j = 0; j < k; j++){
                int i = index.getOrDefault(arr[k] - arr[j], -1);
                if(i >= 0 && i < j){
                    int cand = longest.getOrDefault(i * n + j, 2)+1;
                    longest.put(j * n + k, cand);
                    result = Math.max(result, cand);
                }
            }
        }
        return result >= 3 ? result : 0;
    }
}

