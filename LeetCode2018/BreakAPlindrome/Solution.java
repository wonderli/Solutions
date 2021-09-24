import java.util.*;
class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() <= 1) return "";
        
        char[] cs = palindrome.toCharArray();
        for(int i = 0; i < cs.length/2; i++){
            if(cs[i] != 'a') {
                cs[i] = 'a';
                return new String(cs);
            }
        }
        
        cs[cs.length-1] = 'b';
        
        return new String(cs);
    }
}
