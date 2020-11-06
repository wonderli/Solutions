import java.util.*;
public class Solution2{
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<List<String>> ret = new ArrayList<>();
        if(s.length() == 1){
            List<String> curr = new ArrayList<>();
            curr.add(s);
            ret.add(curr);
            return ret;
        }
        List<String> curr = new ArrayList<>();
        helper(s, curr, ret);
        return ret;
    }
    private void helper(String s, List<String> curr, List<List<String>> ret){
        if(s.length() == 0){
            ret.add(curr);
            return;
        }
        for(int i = 1; i <= s.length(); i++){
            String c = s.substring(0, i);
            if(isPalindrome(c)){
                curr.add(c);
                String newS = s.substring(i);
                helper(newS, new ArrayList<>(curr), ret);
                curr.remove(curr.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
