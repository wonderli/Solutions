import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        int num[] = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = i + 1;
        }
        ArrayList<Integer> curr = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        helper(0, k, num, curr, ret);
        return ret;
    }
    public void helper(int index, int k, int num[], ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ret){
        if(curr.size() == k){
            ret.add(curr);
            return;
        }
        for(int i = index; i < num.length; i++){
            ArrayList<Integer> t = new ArrayList<Integer>(curr);
            curr.add(num[i]);
            helper(i + 1, k, num, curr, ret);
            curr = t;
        }
    }
    public static void print(ArrayList<ArrayList<Integer>> r){
        for(ArrayList<Integer> e : r){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        print(sol.combine(4, 2));
    }
}
