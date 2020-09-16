import java.util.*;
public class Solution{
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = -1;
        int sum = 0;
        int n = nums.length;
        int res = n + 1;
        while(left < nums.length){
            if((right + 1) < n && sum < s){
                right++;
                sum += nums[right];
            }else {
                sum -= nums[left];
                left++;
            }
            if(sum >= s){
                res = Math.min(res, right - left + 1);
            }
        }
        if(res == n + 1){
            return 0;
        }
        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
