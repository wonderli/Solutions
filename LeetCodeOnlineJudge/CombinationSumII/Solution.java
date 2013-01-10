//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//Each number in C may only be used once in the combination.
import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if(num == null) return null;
        if(target == 0) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int backtrack[] = new int[num.length + 1];
        backtrack[0] = -1;
        f(num, 0, target, ret, backtrack, 0);
        return ret;
    }
    public void f(int[] num, int sum, int target, ArrayList<ArrayList<Integer>> result, int[] backtrack, int index){
        if(target == sum){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int i = 1; i <= index; i++){
                tmp.add(num[backtrack[i]]);
            }
            result.add(tmp);
        }
        if(target < sum){
            return;
        }
        for(int i = backtrack[index] + 1; i < num.length; i++){
            backtrack[index+1] = i;
            f(num, sum + num[i], target, result, backtrack, index+1);
            while(i+1 < num.length && num[i+1] == num[i]){
                i++;
            }
        }
    }
    public static void main(String args[]){
        //int num[] = {1,2};
        int num[] = {3,1,3,5,1,1};
        //int num[] = {1, 1, 1,3, 3, 5};
        int target = 8;
        //int num[] = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        //int target = 27;
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> ret = s.combinationSum2(num, target);
        for(ArrayList<Integer> e : ret){
            System.out.println(e);
        }

    }
}
