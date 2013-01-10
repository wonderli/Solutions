//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//For example, given candidate set 2,3,6,7 and target 7, 
//A solution set is: 
//[7] 
//[2, 2, 3] 
import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null) return null;
        if(target == 0) return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        int i = 0; 
        int j = candidates.length - 1;
        while(i < j){
            int tmp = candidates[i];
            candidates[i] = candidates[j];
            candidates[j] =tmp;
            i++;
            j--;
        }
        return f(candidates, target, 0);
    }
    public ArrayList<ArrayList<Integer>> f(int[] candidates, int target, int index){
        if(target == 0) {
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        if(index >= candidates.length) return null;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; candidates[index] * i <= target; i++){
            ArrayList<ArrayList<Integer>> tmp = f(candidates, target - candidates[index] * i, index + 1);
            if(tmp != null){
                for(ArrayList<Integer> e : tmp){
                    for(int j = 0; j < i; j++){
                        e.add(candidates[index]);
                    }
                }
            ret.addAll(tmp);
            }
        }
        return ret;
    }
    public static void main(String args[]){
        int candidates[] = {2, 3, 6, 7};
        int target = 7;
        Solution s  = new Solution();
        ArrayList<ArrayList<Integer>> ret = s.combinationSum(candidates, target);
        for(ArrayList<Integer> e : ret){
            System.out.println(e);
        }
    }
}
