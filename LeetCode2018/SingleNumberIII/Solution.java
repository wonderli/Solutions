import java.util.*;
class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : nums){
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int e : map.keySet()){
            if(map.get(e) == 1){
                result.add(e);
            }
        }
        int[] res = new int[2];
        res[0] = result.get(0);
        res[1] = result.get(1);
        return res;
    }
}
