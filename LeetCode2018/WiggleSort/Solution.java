import java.util.*;
class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            int min = Math.min(nums[i], nums[i-1]);
            int max = Math.max(nums[i], nums[i-1]);
            if(i % 2== 1){
                nums[i-1] = min;
                nums[i] = max;
            }else{
                nums[i] = min;
                nums[i-1] = max;
            }
        }
    }
}