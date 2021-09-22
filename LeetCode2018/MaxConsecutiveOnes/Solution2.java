import java.util.*;
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int i = -1;
        int j = 0;
        while(j < nums.length && nums[j] == 0){
            j++;
        }
        
        if(j == nums.length) return 0;
        
        i = j - 1;
        for(; j < nums.length; j++){
            if(nums[j] == 0){
                max = Math.max(max, j - i - 1);
                i = j;
            }
        }
        
        max = Math.max(max, j - 1 - i);
        return max;
        
    }
}