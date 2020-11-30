import java.util.*;
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = left(nums, target);
        int r = right(nums, target);
        return new int[]{l, r};
    }
    
    private int left(int[] nums, int target){
        int l = 0;
        int r = nums.length- 1;
        int ret = -1;
        while(l <=r){
            int mid = l + (r -l)/2;
            if(nums[mid] == target){
                ret = mid;
                r = mid - 1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ret;
    }
    
        private int right(int[] nums, int target){
        int l = 0;
        int r = nums.length- 1;
        int ret = -1;
        while(l <=r){
            int mid = l + (r -l)/2;
            if(nums[mid] == target){
                ret = mid;
                l = mid + 1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ret;
    }
}