import java.util.*;
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        int prev = nums[1] - nums[0];
        int count = prev == 0 ? 1 : 2;
        int max = 0;
        for(int i = 2; i < n; i++){
            int curr = nums[i] - nums[i-1];
            if((curr > 0 && prev <= 0)||(curr < 0 && prev >= 0)){
                count++;
                prev = curr;
            }
        }
        return count;
        
    }
}
