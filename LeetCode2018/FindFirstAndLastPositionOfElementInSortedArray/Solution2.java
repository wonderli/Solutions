import java.util.*;
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = helper(nums, target, true);
        int r = helper(nums, target, false);
        return new int[]{l, r};
    }
    
    private int helper(int[] nums, int target, boolean isLeft){
        int l = 0;
        int r = nums.length- 1;
        int ret = -1;
        while(l <=r){
            int mid = l + (r -l)/2;
            if(nums[mid] == target){
                ret = mid;
                if(isLeft){
                    r = mid - 1;
                }else {
                    l = mid +1;
                }
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ret;
    }
}