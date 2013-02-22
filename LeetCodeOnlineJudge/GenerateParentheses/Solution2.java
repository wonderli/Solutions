// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
// For example, given n = 3, a solution set is: 
// "((()))", "(()())", "(())()", "()(())", "()()()"
import java.util.*;
public class Solution2{
//    public ArrayList<String> generateParenthesis(int n) {
//        if(n == 1){
//            ArrayList<String> ret = new ArrayList<String>();
//            ret.add("()");
//            return ret;
//        }
//        HashSet<String> set = new HashSet<String>();
//        ArrayList<String> prev = generateParenthesis(n-1);
//        for(String s : prev){
//            set.add("()" + s);
//            set.add(s + "()");
//            set.add("(" + s + ")");
//        }
//        return new ArrayList<String>(set);
//    }
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<String>();
        String curr = new String();
        f(n, n, ret, curr);
        return ret;
    }
    public void f(int left, int right, ArrayList<String> r, String curr){
        if(left < 0 || (left > right)) return;
        if(left == 0 && right == 0){
            r.add(curr);
            return;
        }
        f(left - 1, right, r, curr + "(");
        f(left, right - 1, r, curr + ")");
    }
    public static void main(String args[]){
        Solution2 s = new Solution2();
        int n = 2;
        ArrayList<String> ret = s.generateParenthesis(n);
        for(String e : ret){
            System.out.println(e);
        }
    }
}
