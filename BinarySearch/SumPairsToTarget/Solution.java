import java.util.*;

class Solution {
    public int solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int e : nums){
            if(map.containsKey(target - e)){
                int v = map.get(target - e);
                v--;
                if(v == 0){
                    map.remove(target - e);
                }else{
                    map.put(target - e, v);
                }
                count ++;
            }else{
                map.put(e, map.getOrDefault(e, 0)+1);
            }
            
        }
        return count;
    }
}