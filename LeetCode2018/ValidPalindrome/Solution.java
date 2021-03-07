import java.util.*;
class Solution{
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true; int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        String sb = new String();
        while(i < j){
            while(i < s.length() && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(j >= 0 && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(i < s.length() && j >= 0 && s.charAt(i) == s.charAt(j) || (i>=j)) {
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;

    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(sol.isPalindrome(s));
        s = "race a car";
        s = ".";
        System.out.println(sol.isPalindrome(s));
    }
}