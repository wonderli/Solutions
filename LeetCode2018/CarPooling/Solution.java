import java.util.*;
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
       Map<Integer, Integer> map = new TreeMap<>();
        for(int[] t : trips){
            int startPassenger = map.getOrDefault(t[1], 0) + t[0];
            map.put(t[1], startPassenger);
            
            int endPassenger = map.getOrDefault(t[2], 0) - t[0];
            map.put(t[2], endPassenger);
        }
        
        int curr = 0;
        for(int p : map.values()){
            curr += p;
            if(curr > capacity){
                return false;
            }
        }
        return true;
        
    }
}
