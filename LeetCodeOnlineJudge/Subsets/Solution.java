//Subsets
// Given a set of distinct integers, S, return all possible subsets.
//
// Note:
//
//     Elements in a subset must be in non-descending order.
//         The solution set must not contain duplicate subsets.
//
import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if(S.length > 0) Arrays.sort(S);
        ArrayList<ArrayList<Integer>> ret = helper(S, S.length);
        return ret;
    }
    public ArrayList<ArrayList<Integer>> helper(int[] S, int index){
        ArrayList<ArrayList<Integer>> allSubset = new ArrayList<ArrayList<Integer>>();
        if(index == 0){
            allSubset.add(new ArrayList<Integer>());
            return allSubset;
        }
        allSubset = helper(S, index - 1);
        int e = S[index - 1];
        ArrayList<ArrayList<Integer>> more = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> sub : allSubset){
            ArrayList<Integer> newSubset = new ArrayList<Integer>();
            newSubset.addAll(sub);
            newSubset.add(e);
            more.add(newSubset);
        }
        allSubset.addAll(more);
        return allSubset;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int A[] = {1, 2, 3};
        ArrayList<ArrayList<Integer>> ret = sol.subsets(A);
        for(ArrayList<Integer> e : ret){
            System.out.println(e);
        }
    }
}
