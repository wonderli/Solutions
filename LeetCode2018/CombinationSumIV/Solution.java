import java.util.*;
class Solution {
    Map<Integer, Integer> cache = new HashMap<>(); 
    public int combinationSum4(int[] nums, int target) {
        if(target == 0) return 1;
        if(cache.containsKey(target)){
            return cache.get(target);
        }
        int result = 0;
        for(int e : nums){
            if(target - e >= 0){
                result += combinationSum4(nums, target - e);
            }
        }
        cache.put(target, result);
        return result;
    }
}