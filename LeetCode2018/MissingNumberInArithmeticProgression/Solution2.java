import java.util.*;
class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int diff = (arr[n-1] - arr[0]) /n;
        int l = 0;
        int r = n-1;
        while(l < r){
            int mid = l + (r - l)/2;
            if(arr[mid] == arr[0] + mid * diff){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return arr[0] + diff * l;
    }
}
