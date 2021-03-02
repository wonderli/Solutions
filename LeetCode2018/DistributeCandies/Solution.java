import java.util.*;
public class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int c : candyType){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return Math.min(n/2, map.size());
        
    }
}
