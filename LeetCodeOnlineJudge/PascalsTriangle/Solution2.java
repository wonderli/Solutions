//Given numRows, generate the first numRows of Pascal's triangle.
//
//For example, given numRows = 5,
import java.util.*;
public class Solution2{
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        if(numRows == 0||numRows == 1) {
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
            if(numRows == 1){
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(1);
                ret.add(a);
            }
            return ret;
        }
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        int dp[][] = new int[numRows][numRows];
        for(int i = 0; i < numRows; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < numRows; i++){
            for(int j = 1; j < numRows; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i - 1][j];
            }
        }
        for(int i = 0; i < numRows; i++){
            ArrayList<Integer> a = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                a.add(dp[i][j]);
            }
            ret.add(a);
        }
        return ret;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        ArrayList<Integer> al = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        int numRows = 5;
        ret = sol.generate(numRows);
        for(ArrayList<Integer> e : ret){
            System.out.println(e);
        }
    }
}
