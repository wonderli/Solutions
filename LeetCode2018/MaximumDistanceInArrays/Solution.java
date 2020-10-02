import java.util.*;
public class Solution{
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        int minValue = arrays.get(0).get(0);
        int maxValue = arrays.get(0).get(arrays.get(0).size() - 1);
        for(int i = 1; i < arrays.size(); i++){
            List<Integer> curr = arrays.get(i);
            int first = curr.get(0);
            int last = curr.get(curr.size() - 1);
            res = Math.max(res, Math.max(Math.abs(last - minValue), Math.abs(first - maxValue)));
            minValue = Math.min(minValue, first);
            maxValue = Math.max(maxValue, last);
        }
        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
