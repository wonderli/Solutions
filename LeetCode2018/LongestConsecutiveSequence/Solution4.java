import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int max = 0;
        for(int e : nums){
            if(!map.containsKey(e)){
                int left = map.getOrDefault(e-1, 0);
                int right = map.getOrDefault(e+1, 0);
                int sum = left + 1 + right;
                map.put(e, sum);
                max = Math.max(max, sum);
                map.put(e - left, sum);
                map.put(e + right, sum);
            }
        }
        return max;
    }
}
