import java.util.*;

class Solution {
    int count = 0;
    public int solve(int[] nums, int target) {
        int n = nums.length;
        helper(nums, 0, target);
        return count;
    }
    private void helper(int[] nums, int index, int target){
        if(index == nums.length){
            count += (target == 0) ? 1 : 0;
            return;
        }
        helper(nums, index+1, target - nums[index]);
        helper(nums, index+1, target + nums[index]);
    }
}