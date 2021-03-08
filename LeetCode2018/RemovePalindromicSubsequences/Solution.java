import java.util.*;
class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        int count1 = 0;
        int count2 = 0;
        if(isPalindrome(s)){
            return 1;
        }
        return 2;
    }
    
    private boolean isPalindrome(String s){
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}
