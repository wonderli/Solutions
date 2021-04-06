import java.util.*;
class Solution {
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        int max = 0;
        for(int i = 0; i < n - 2; i++){
            max = Math.max(max, A[i]);
            if(max > A[i+2]){
                return false;
            }
        }
        return true;
    }
}
