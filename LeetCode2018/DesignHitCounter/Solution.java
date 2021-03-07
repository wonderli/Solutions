import java.util.*;
class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class HitCounter {

    private  NavigableMap<Integer, Integer> map;
    private int FiveMins = 300;
    /** Initialize your data structure here. */
    public HitCounter() {
        map = new TreeMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        map.put(timestamp, map.getOrDefault(timestamp, 0)+1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int last5Min = timestamp - FiveMins;
         NavigableMap<Integer, Integer> subMap = map.subMap(last5Min, false, timestamp, true);
        int sum = 0;
        for(int t : subMap.keySet()){
            sum += subMap.get(t);
        }
        return sum;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */