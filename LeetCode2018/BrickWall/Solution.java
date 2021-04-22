import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> row : wall){
            int sum = 0;
            for(int i = 0; i < row.size() - 1; i++){
                int e = row.get(i);
                sum += e;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int n = wall.size();
        int result = n;
        
        for(int k : map.keySet()){
            result = Math.min(result, n - map.get(k));
        }
        return result;
    }
}