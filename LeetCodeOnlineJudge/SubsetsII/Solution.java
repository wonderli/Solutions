// Given a collection of integers that might contain duplicates, S, return all possible subsets.
//
// Note:
//
//     Elements in a subset must be in non-descending order.
//         The solution set must not contain duplicate subsets.
//
import java.util.*;
public class Solution{
     public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
         Arrays.sort(num);
         if(num.length == 0) return new ArrayList<ArrayList<Integer>>();
         ArrayList<Integer> curr = new ArrayList<Integer>();
         ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
         int index = 0;
         helper(index, num, ret, curr);
         return ret;
     }
     public void helper(int index, int[] num, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> curr){
         if(index == num.length){
             ret.add(curr);
             return;
         }
         for(int i = index; i < num.length; i++){
             if(i > index && num[i] == num[i-1]) continue;
             ArrayList<Integer> t = new ArrayList<Integer>(curr);
             curr.add(num[i]);
             helper(i + 1, num, ret, curr);
             curr = t;
         }
         helper(num.length, num, ret, curr);
     }
    public static void main(String args[]){
        Solution sol = new Solution();
        int num[] = {1, 2, 2};
        ArrayList<ArrayList<Integer>> ret = sol.subsetsWithDup(num);
        for(ArrayList<Integer> e : ret){
            System.out.println(e);
        }
    }
}
