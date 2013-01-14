// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
// For example, given n = 3, a solution set is: 
// "((()))", "(()())", "(())()", "()(())", "()()()"
import java.util.*;
public class Solution{
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
        char s[] = new char[n * 2];
        f(0, n, n, ret, s);
        return ret;
    }
    public void f(int pos, int left, int right, ArrayList<String> r, char[] s){
        if(left < 0 || right < left) return;
        if(left == 0 && right == 0){
            String str = String.copyValueOf(s);
            r.add(str);
        }else{
            if(left > 0){
                s[pos] = '(';
                f(pos + 1, left - 1, right, r, s);
            }
            if(right > left){
                s[pos] = ')';
                f(pos + 1, left, right - 1, r, s);
            }
        }
    }
    public static void main(String args[]){
        Solution s = new Solution();
        int n = 2;
        ArrayList<String> ret = s.generateParenthesis(n);
        for(String e : ret){
            System.out.println(e);
        }
    }
}
