import java.util.*;
class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        Integer majority = null;
        int count = 0;
        for(int i = 0; i < n-1; i++){
            int diff = arr[i+1] - arr[i];
            if(count == 0 || diff == majority){
                majority = diff;
                count++;
            }else{
                count--;
                if(count == 0){
                    majority = diff;
                }
            }
        }
        for(int i = 0; i < n-1; i++){
            int diff = arr[i+1] - arr[i];
            if(diff != majority){
                return arr[i] + majority;
            }
        }
        
        return arr[n-1] + majority;
    }
}
