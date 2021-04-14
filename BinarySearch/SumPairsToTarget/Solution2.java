import java.util.*;

class Solution {
    public int solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : nums){
            map.put(e, map.getOrDefault(e, 0)+1);
        }
        int count = 0;
        for(int k : map.keySet()){
            if(target % 2 == 0 && k == target /2){
                count += map.get(k);
            }else if(map.containsKey(target - k)){
                count += Math.min(map.get(k), map.get(target - k));
            }
        }
        return count/2;
    }
}