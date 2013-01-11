import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if(n == 0 ||k == 0){
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        LinkedList<Integer> curr = new LinkedList<Integer>();
        solve(n, k, 0, ret, curr);
        return ret;
    }
    public void solve(int n, int k, int index, ArrayList<ArrayList<Integer>> result, LinkedList<Integer> curr){
        if(index > n) return;
        if(curr.size() == k){
           result.add(new ArrayList<Integer>(curr));
           return;
        }
        for(int i = index; i <= n; i++){
            curr.add(i + 1);
            solve(n, k, i+1, result, curr);
            curr.removeLast();
        }
    }
    public static void main(String args[]){
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> ret = s.combine(4, 3);
        for(ArrayList<Integer> e : ret){
            System.out.println(e);
        }

    }
}
