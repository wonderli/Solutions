import java.util.*;
class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    private int helper(int[] nums, int left, int right){
        if(left > right) return Integer.MIN_VALUE;
        if(left == right) return nums[left];
        int mid = left + (right - left)/2;
        int leftSum = helper(nums, left, mid);
        int rightSum = helper(nums, mid+1, right);
        int cross = cross(nums, left, right, mid);
        return Math.max(cross, Math.max(leftSum, rightSum));
    }
    private int cross(int[] nums, int left, int right, int mid){
        int currSum = 0;
        int leftSum = Integer.MIN_VALUE;
        for(int i = mid; i>= left; i--){
            currSum += nums[i];
            leftSum = Math.max(leftSum, currSum);
        }
        currSum = 0;
        int rightSum = Integer.MIN_VALUE;
        for(int i = mid + 1; i <= right; i++){
            currSum += nums[i];
            rightSum = Math.max(rightSum, currSum);
        }
        return leftSum + rightSum;
    }
}