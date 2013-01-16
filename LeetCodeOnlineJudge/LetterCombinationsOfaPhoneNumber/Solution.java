//Given a digit string, return all possible letter combinations that the number could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below.
import java.util.*;
public class Solution{
    public ArrayList<String> letterCombinations(String digits) {
        if(digits == null) return null;
        if(digits.length() == 0) {
            ArrayList<String> ret = new ArrayList<String>();
            ret.add(new String());
            return ret;
        }
        String pad[] = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> ret = new ArrayList<String>();
        String result = new String();
        helper(digits, ret, pad, 0,result);
        return ret;
    }
    public void helper(String digits, ArrayList<String> ret, String[] pad, int i, String result){
        if(i == digits.length()){
            ret.add(result);
            return;
        }
        char curr = digits.charAt(i);
        int d = Character.getNumericValue(curr);
        String s = pad[d];
        for(int m = 0; m < s.length(); m++){
            String str = result + s.charAt(m);
            helper(digits, ret, pad, i+1, str);
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = new String("23");
        ArrayList<String> ret = sol.letterCombinations(s);
        for(String e : ret){
            System.out.println(e);
        }
    }
}
