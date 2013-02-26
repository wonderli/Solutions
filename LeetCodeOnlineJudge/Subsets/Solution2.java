//Subsets
// Given a set of distinct integers, S, return all possible subsets.
//
// Note:
//
//     Elements in a subset must be in non-descending order.
//         The solution set must not contain duplicate subsets.
//
import java.util.*;
public class Solution2{
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if(S.length > 0) Arrays.sort(S);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        helper(S, 0, ret, curr);
        return ret;
    }
    public void helper(int[] A, int index, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> curr){
        if(index == A.length){
            ret.add(curr);
            return;
        }
        for(int i = index; i < A.length; i++){
            ArrayList<Integer> t = new ArrayList<Integer>(curr);
            curr.add(A[i]);
            helper(A, i+1, ret, curr);
            curr = t;
        }
        helper(A, A.length, ret, curr);
    }

    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int A[] = {1, 2, 3};
        ArrayList<ArrayList<Integer>> ret = sol.subsets(A);
        for(ArrayList<Integer> e : ret){
            System.out.println(e);
        }
    }
}
