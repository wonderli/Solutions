import java.util.*;
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> below = triangle.get(triangle.size() - 1);
        for(int i = triangle.size() - 2; i >=0; i--){
            List<Integer> curr = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                int bestBelow = Math.min(below.get(j), below.get(j+1));
                curr.add(bestBelow + triangle.get(i).get(j));
            }
            below = curr;
        }
        return below.get(0);
        
    }
}