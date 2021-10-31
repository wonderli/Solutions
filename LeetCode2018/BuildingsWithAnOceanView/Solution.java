import java.util.*;
class Solution {
    public int[] findBuildings(int[] heights) {
        if(heights.length == 0) return new int[0];
       if(heights.length == 1) return new int[]{0}; 
       int n = heights.length;
        int[] arr = new int[n+1];
        arr[n] = 0;
        for(int i = n-1; i >= 0; i--){
            arr[i] = Math.max(arr[i+1], heights[i]);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(heights[i] > arr[i+1]){
                result.add(i);
            }
        }
        int[] ret = new int[result.size()];
        for(int i = 0; i < ret.length; i++){
            ret[i] = result.get(i);
        }
        return ret;
    }
}
