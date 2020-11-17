import java.util.*;
class Solution {
    public int longestMountain(int[] A) {
        int max = 0;
        int inc = 0;
        int desc = 0;
        for(int i = 1 ; i < A.length; i++){
            if(A[i] > A[i-1]){
                if(desc > 0) {
                    inc = 0;
                }
                inc++;
                desc = 0;
            }else if(A[i] < A[i-1]){
                if(inc > 0){
                    desc++;
                    max = Math.max(max, inc +desc + 1);
                }
            }else{
                inc = 0;
                desc = 0;
            }
        }
        return max;
        
        
    }
}