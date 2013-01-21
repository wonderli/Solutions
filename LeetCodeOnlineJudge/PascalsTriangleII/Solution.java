//Given numRows, generate the first numRows of Pascal's triangle.
//
//For example, given numRows = 5,
import java.util.*;
public class Solution{
    public ArrayList<Integer> getRow(int rowIndex) {
        if(rowIndex == 0) {
            ArrayList<Integer> ret = new ArrayList<Integer>();
            ret.add(1);
            return ret;
        }
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> ret = helper(0, rowIndex, a);
        return ret;
    }
    public ArrayList<Integer> helper(int curr, int level, ArrayList<Integer> last){
        if(curr == level + 1)  return last;
        if(curr == 0 || curr == 1){
            ArrayList<Integer> a = new ArrayList<Integer>();
            a.add(1);
            if(curr == 1){
                a.add(1);
            }
            return helper(curr + 1, level, a);
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
        return helper(curr+1, level, a);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int numRows = 4;
        ret = sol.getRow(numRows);
        //ArrayList<Integer> a = new ArrayList<Integer>();
        //sol.helper(0, numRows, a);
        System.out.println(ret);
    }
}
