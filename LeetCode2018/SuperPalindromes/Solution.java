import java.util.*;
class Solution {
    public int superpalindromesInRange(String left, String right) {
        List<Long> plist = new ArrayList<>();
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        
        for(long i = 1; i<= 9; i++){
            plist.add(i);
        }
        for(long i = 1; i < 10000; i++){
            String ls = Long.toString(i);
            String rs = new StringBuilder(ls).reverse().toString();
            plist.add(Long.parseLong(ls + rs));
            for(long d = 0;  d < 10; d++){
                plist.add(Long.parseLong(ls + d + rs));
            }
        }
        
        int count = 0;
        for(long p : plist){
            long s = p * p;
            if(!isPalindrome(Long.toString(s))){
                continue;
            }
            if(l <= s && s <= r){
                count++;
            }
        }
        return count;
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