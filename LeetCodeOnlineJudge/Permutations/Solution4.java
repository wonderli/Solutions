// Permutations
// Given a collection of numbers, return all possible permutations.
//
// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
import java.util.*;
public class Solution4{
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num.length == 0){
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        ArrayList<Integer> curr = new ArrayList<Integer>();
        helper(0, num, curr, ret);
        return ret;
    }
    public void helper(int index, int num[], ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ret){
        if(curr.size() ==  num.length){
            ret.add(curr);
            return;
        }
        for(int i = index; i < num.length; i++){
            swap(num, index, i);
            int first = num[index];
            ArrayList<Integer> tmp = new ArrayList<Integer>(curr);
            curr.add(first);
            helper(index + 1, num, curr, ret);
            curr = tmp;
            swap(num, index, i);
        }
    }
    public void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    public static void main(String args[]){
        Solution4 sol = new Solution4();
        int num[] = {1, 2, 3};
        ArrayList<ArrayList<Integer>> r = sol.permute(num);
        for(ArrayList<Integer> e : r){
            System.out.println(e.toString());
        }
    }
}
