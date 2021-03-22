import java.util.*;
class Solution {
    public boolean reorderedPowerOf2(int N) {
        int[] count = count(N);
        for(int i = 0; i < 31; i++){
            if(Arrays.equals(count, count(1 << i))){
                return true;
            }
        }
        return false;
        
    }
    private int[] count(int N){
        int[] res = new int[10];
        while(N > 0){
            res[N%10]++;
            N = N/10;
        }
        return res;
    }
}
