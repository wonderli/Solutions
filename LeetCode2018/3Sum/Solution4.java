import java.util.*;
class Solution4 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; i++){
            if(i == 0 || nums[i-1] != nums[i]){
                twoSum(nums, i, result);
            }
        }
        return result;
    }
    private void twoSum(int[] nums, int i, List<List<Integer>> result){
        Set<Integer> seen = new HashSet<>();
        for(int j = i + 1; j < nums.length; j++){
            int complement = -(nums[i] + nums[j]);
            if(seen.contains(complement)){
                result.add(Arrays.asList(nums[i], complement, nums[j]));
                while(j + 1 < nums.length && nums[j]==nums[j+1]){
                    j++;
                }
            }
            seen.add(nums[j]);
        }
    }
}