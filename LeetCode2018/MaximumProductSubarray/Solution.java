import java.util.*;
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int maxCurr = nums[0];
        int minCurr = nums[0];
        int result = maxCurr;
        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];
            int tmpMax = Math.max(curr, Math.max(maxCurr * curr, minCurr * curr));
            minCurr= Math.min(curr, Math.min(maxCurr * curr, minCurr * curr));
            maxCurr = tmpMax;
            result =Math.max(maxCurr, result);
        }
        return result;
    }
}