import java.util.*;
class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length;i++){
            int current = nums[i];
            int complement = k - current;
            if(map.getOrDefault(complement, 0) > 0){
                map.put(complement, map.getOrDefault(complement, 0) - 1);
                count++;
            }else{
                map.put(current, map.getOrDefault(current, 0) +1);
            }
        }
        return count;
    }
}
