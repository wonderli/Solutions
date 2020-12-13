import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n-2; i++){
            int j = i + 1;
            int k = n - 1;
            

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(sum - target) < diff){
                    diff = Math.abs(target - sum);
                    result = sum;
                }
                   
                if(sum < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }
}