import java.util.*;
public class Solution{
    public ArrayList<String> generateParenthesis(int n) {
        if(n == 0) return new ArrayList<String>();
        ArrayList<String> ret = new ArrayList<String>();
        String curr = new String();
        helper(n, n, curr, ret);
        return ret;
    }
    public void helper(int left, int right, String curr, ArrayList<String> ret){
        if(left < 0||right < 0) return;
        if(left == 0 && right == 0){
            ret.add(curr);
            return;
        }
        if(right < left) return;
        helper(left - 1, right, curr + "(", ret);
        helper(left, right-1, curr + ")", ret);
    }
    public static void print(ArrayList<String> r){
        for(String e: r){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        print(sol.generateParenthesis(2));
    }
}
