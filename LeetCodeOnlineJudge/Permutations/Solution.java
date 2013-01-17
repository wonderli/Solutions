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
        int first = num[0];
        int[] rem = Arrays.copyOfRange(num, 1, num.length);
        ArrayList<ArrayList<Integer>> p = permute(rem);
        for(ArrayList<Integer> e : p){
            for(int i = 0; i <= e.size(); i++){
                ArrayList<Integer> c = (ArrayList<Integer>)e.clone();
                c.add(i, first);
                ret.add(c);
            }
        }
        return ret;
    }
    public void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int num[] = {1, 2, 3};
        ArrayList<ArrayList<Integer>> r = sol.permute(num);
        for(ArrayList<Integer> e : r){
            System.out.println(e.toString());
        }
    }
}
