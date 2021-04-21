import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return 0;
        int l = 0;
        
        
        int count = 0;
        int maxLen = 0;
        for(int r = 0; r < n; r++){
            if(nums[r] == 0){
                count++;
            }
            while(count > k){
                if(nums[l] == 0){
                    count--;
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}

