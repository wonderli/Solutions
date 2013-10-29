import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if(S == null||S.length == 0) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(S);
        helper(0, S, curr, ret);
        return ret;
    }
    public void helper(int index, int S[], ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ret){
        if(index == S.length){
            ret.add(curr);
            return;
        }
        for(int i = index; i < S.length; i++){
            ArrayList<Integer> t = new ArrayList<Integer>(curr);
            curr.add(S[i]);
            helper(i + 1, S, curr, ret);
            curr = t;
        }
        helper(S.length, S, curr, ret);
    }
    public void print(ArrayList<ArrayList<Integer>> a){
        for(ArrayList<Integer> e : a){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int s[] = {1, 2, 3};
        ArrayList<ArrayList<Integer>> ret = sol.subsets(s);
        sol.print(ret);
    }
}
