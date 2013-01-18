// Permutations
// Given a collection of numbers, return all possible permutations.
//
// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
import java.util.*;
public class Solution{
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
        Arrays.sort(num);
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
        int last = -1;
        for(int i = 0; i < len; i++){
            if(last > -1 && num[i] == num[last]) continue;
            if(mark[i] == true) continue;
            else {
                ArrayList<Integer> t = (ArrayList<Integer>)s.clone();
                s.add(num[i]);
                mark[i] = true;
                helper(num, mark, ret, s);
                s = t;
                mark[i] = false;
                last = i;
            }
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int num[] = {1, 2, 1};
        ArrayList<ArrayList<Integer>> r = sol.permute(num);
        for(ArrayList<Integer> e : r){
            System.out.println(e);
        }
    }
}
