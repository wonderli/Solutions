//Given numRows, generate the first numRows of Pascal's triangle.
//
//For example, given numRows = 5,
import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        if(numRows == 0) {
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
            return ret;
        }
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        helper(0, numRows, a, ret);

        return ret;
    }
    public void helper(int curr, int level, ArrayList<Integer> last, ArrayList<ArrayList<Integer>> ret){
        if(ret.size() == level) return;
        if(curr == 0 || curr == 1){
            ArrayList<Integer> a = new ArrayList<Integer>();
            a.add(1);
            if(curr == 1){
                a.add(1);
            }
            ret.add(a);
            helper(curr + 1, level, a, ret);
            return;
        }
        int len = last.size();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        for(int i = 1; i < len; i++){
            int c = last.get(i-1);
            int d = last.get(i);
            int b = c + d;
            a.add(b);
        }
        a.add(1);
        ret.add(a);
        helper(curr+1, level, a, ret);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        ArrayList<Integer> al = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        int numRows = 4;
        ret = sol.generate(numRows);
        for(ArrayList<Integer> e : ret){
            System.out.println(e);
        }
    }
}
