import java.util.*;
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        for(j = 0; j < n; j++){
            if(nums[j] == 0) k--;
            if(k < 0){
                if(nums[i] == 0) {
                    k++;
                }
                i++;
            }
        }
        return j - i;
    }
    
}
