import java.util.*;
public class Solution{
    boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;
        int len = s.length();
        s = s.toLowerCase();
        int i = 0;
        int j = len - 1;
        while(i <= j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }else{
                if(s.charAt(i) == s.charAt(j)){
                    i++;
                    j--;
                }else return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(sol.isPalindrome(s));
    }
}
