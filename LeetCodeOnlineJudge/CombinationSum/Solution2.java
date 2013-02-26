//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//For example, given candidate set 2,3,6,7 and target 7, 
//A solution set is: 
//[7] 
//[2, 2, 3] 
import java.util.*;
public class Solution2{
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null) return null;
        if(target == 0) return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        helper(0, target, candidates, curr, ret);
        return ret;
    }

    public void helper(int index, int target, int[] candidates, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ret){
        if(target == 0){
            ret.add(curr);
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(target < candidates[i]) break;
            ArrayList<Integer> t = new ArrayList<Integer>(curr);
            curr.add(candidates[i]);
            helper(i, target - candidates[i], candidates, curr, ret);
            curr = t;
        }
    }
    public static void main(String args[]){
        int candidates[] = {2, 3, 6, 7};
        int target = 7;
        Solution2 s  = new Solution2();
        ArrayList<ArrayList<Integer>> ret = s.combinationSum(candidates, target);
        for(ArrayList<Integer> e : ret){
            System.out.println(e);
        }
    }
}
