import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if(num == null || num.length == 0) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(0, num, curr, ret);
        return ret;
    }
    public void helper(int index, int num[], ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ret){
        if(index == num.length){
            ret.add(curr);
            return;
        }
        for(int i = index; i < num.length; i++){
            if(i > index && num[i] == num[i-1]) continue;
            ArrayList<Integer> t = new ArrayList<Integer>(curr);
            curr.add(num[i]);
            helper(i + 1, num, curr, ret);
            curr = t;
        }
        helper(num.length, num, curr, ret);
    }
    public void print(ArrayList<ArrayList<Integer>> curr){
        for(ArrayList<Integer> e : curr){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int s[] = {1, 2, 2};
        ArrayList<ArrayList<Integer>> ret = sol.subsetsWithDup(s);
        sol.print(ret);
    }
}
