// Permutations
// Given a collection of numbers, return all possible permutations.
//
// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
import java.util.*;
public class Solution3{
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num.length == 0){
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        boolean mark[] = new boolean[num.length];
        for(int i = 0; i < num.length; i++){
            mark[i] = false;
        }
        ArrayList<Integer> s = new ArrayList<Integer>();
        helper(num, mark, ret, s);
        return ret;
    }
    public void helper(int[] num, boolean[] mark, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> s){
        int len = num.length;
        if(s.size() == len){
            ret.add(s);
            return;
        }
        for(int i = 0; i < len; i++){
            if(mark[i] == true) continue;
            else {
                ArrayList<Integer> t = (ArrayList<Integer>)s.clone();
                s.add(num[i]);
                mark[i] = true;
                helper(num, mark, ret, s);
                s = t;
                mark[i] = false;
            }
        }
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
        int num[] = {1, 2, 3};
        ArrayList<ArrayList<Integer>> r = sol.permute(num);
        for(ArrayList<Integer> e : r){
            System.out.println(e);
        }
    }
}
