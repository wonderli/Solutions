import java.util.*;
class Solution {
    public int maxNumberOfApples(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int curr = 5000;
        int count = 0;
        for(int i = 0; i < n; i++){
            curr -= arr[i];
            if(curr >= 0){
                count++;
            }
        }
        return count;        
    }
}
