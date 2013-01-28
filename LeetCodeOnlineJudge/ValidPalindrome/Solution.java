// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome. 
import java.util.*;
public class Solution{
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        int len = s.length();
        if(len < 2) return true;
        StringBuilder sb= new StringBuilder();
        s = s.toLowerCase();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)||Character.isDigit(c)){
                sb.append(c);
            }
        }
        String str = sb.toString();
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
