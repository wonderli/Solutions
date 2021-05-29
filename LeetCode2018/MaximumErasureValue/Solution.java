import java.util.*;
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int l = -1;
        int sum = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i]) && map.get(nums[i]) > l){
                l = map.get(nums[i]);
            }
            map.put(nums[i], i);
            sum = prefix[i+1] - prefix[l+1];
            max = Math.max(max, sum);
        }
        return max;
    }
}