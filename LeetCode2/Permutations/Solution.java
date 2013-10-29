import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num == null || num.length == 0) return new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        boolean mark[] = new boolean[len];
        for(int i = 0; i < len; i++){
            mark[i] = false;
        }
        helper(mark, num, curr, ret);
        return ret;
    }
    public void helper(boolean mark[], int num[], ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ret){
        if(curr.size() == num.length){
            ret.add(curr);
            return;
        }
        for(int i = 0; i < num.length; i++){
            if(!mark[i]){
                mark[i] = true;
                ArrayList<Integer> t = new ArrayList<Integer>(curr);
                curr.add(num[i]);
                helper(mark, num, curr, ret);
                curr = t;
                mark[i] = false;
            }
            
        }
    }
    public void print(ArrayList<ArrayList<Integer>> a){
        for(ArrayList<Integer> e : a){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int num[] = {1, 2, 3};
        sol.print(sol.permute(num));
        
    }
}
