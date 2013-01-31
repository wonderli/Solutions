//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
import java.util.*;
public class Solution{
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.size() == 0 || triangle.get(triangle.size() - 1).size() == 0) return 0;
        int m = triangle.size();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < triangle.size(); i++){
            ArrayList<Integer> e = triangle.get(i);
            ret.add(0, i > 0 ? e.get(0) + ret.get(0) : e.get(0));
            for(int j = 1; j < ret.size() - 1; j++){
                ret.set(j, Math.min(ret.get(j), ret.get(j+1)) + e.get(j));
            }
            if(ret.size() > 1){
                ret.set(ret.size() - 1, ret.get(ret.size() - 1) + e.get(ret.size() - 1));
            }
        }
        int min = Integer.MAX_VALUE;
        for(Integer e : ret){
            min = Math.min(e, min);
        }
        return min;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
