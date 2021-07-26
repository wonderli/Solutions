import java.util.*;
class Solution {
    public int findIntegers(int n) {
        return 1 + helper(1, n);
    }
    private int helper(int num, int limit){
        if(num > limit){
            return 0;
        }
        
        if((num & 1) == 1){
            return 1 + helper((num << 1) |0, limit);
        }else{
            return 1 + helper((num << 1) |0, limit) + helper((num << 1) |1, limit);
        }
    }
}