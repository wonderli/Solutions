//Given a digit string, return all possible letter combinations that the number could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below.
import java.util.*;
public class Solution2{
    public ArrayList<String> letterCombinations(String digits) {
        if(digits == null) return null;
        if(digits.length() == 0) {
            ArrayList<String> ret = new ArrayList<String>();
            ret.add(new String());
            return ret;
        }
        String pad[] = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> ret = new ArrayList<String>();
        String curr = new String();
        helper(0, digits, curr, ret, pad);
        return ret;
    }
    public void helper(int index, String digits, String curr, ArrayList<String> ret, String pad[]){
        if(index == digits.length()){
            ret.add(curr);
            return;
        }
        char c = digits.charAt(index);
        int d = Character.getNumericValue(c);
        for(int i = 0; i < pad[d].length(); i++){
            char e = pad[d].charAt(i);
            helper(index + 1, digits, curr + e, ret, pad);
        }

    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        String s = new String("23");
        ArrayList<String> ret = sol.letterCombinations(s);
        for(String e : ret){
            System.out.println(e);
        }
    }
}
