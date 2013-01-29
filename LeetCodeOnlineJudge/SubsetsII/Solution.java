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
         helper(num, ret, curr, index);
         return ret;
     }
     public void helper(int[] num, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> curr, int index){
         if(index == num.length){
             //System.out.println("ADD\t" + curr);
             ret.add(curr);
             return;
         }
         for(int i = index; i < num.length; i++){
             if(i > index && num[i] == num[i-1]) continue;
             ArrayList<Integer> e = (ArrayList<Integer>)curr.clone();
             curr.add(num[i]);
             //System.out.println("Inside:\t" + curr);
             helper(num, ret, curr, i + 1);
             curr = e;
         }
         //System.out.println("TEST:\t" + curr);
         helper(num, ret, curr, num.length);
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
