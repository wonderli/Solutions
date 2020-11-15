import java.util.*;
class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int x = toBeRemoved[0];
        int y = toBeRemoved[1];
        List<List<Integer>> ret = new ArrayList<>();
        for(int[] interval : intervals){
            int a = interval[0];
            int b = interval[1];
            
            if(b < x || y < a) {
                ret.add(Arrays.asList(a, b));
            }else if(a < x && x < b && y > b){
                List<Integer> e = Arrays.asList(a, x);
                ret.add(e);
            }else if(a < x && y <= b){
                List<Integer> e1 = Arrays.asList(a, x);
                List<Integer> e2 = Arrays.asList(y, b);
                ret.add(e1);
                ret.add(e2);
            }else if(a <= y && y < b){
                List<Integer> e = Arrays.asList(y, b);
                ret.add(e);
            }
        }
        return ret;
    }
}