import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] -1 != i){
                result.add(nums[i]);
            }
        }
        return result;
    }
    
    public void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
