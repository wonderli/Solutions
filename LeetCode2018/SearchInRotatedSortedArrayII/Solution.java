import java.util.*;
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            while(l < r && nums[l] == nums[l + 1]){
                l++;
            }
            while(l < r && nums[r] == nums[r -1]){
                r--;
            }
            
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                return true;
            }
            
            if(nums[mid] >= nums[l]){
                if(nums[l] <= target && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid+1;
                }
            }else {
                if(target <= nums[r] && target > nums[mid]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}