import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(nums[Math.abs(curr) - 1] < 0) {
                result.add(Math.abs(curr));
            }else{
                nums[Math.abs(curr)-1] *= -1;
            }
        }
        return result;
    }
}