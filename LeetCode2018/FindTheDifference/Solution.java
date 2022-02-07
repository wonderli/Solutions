import java.util.*;
class Solution {
    public char findTheDifference(String s, String t) {
        int[] cs = new int[26];
        for(char c : s.toCharArray()){
            cs[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            cs[c - 'a']--;
            if(cs[c - 'a'] < 0){
                return c;
            }
        }
        
        return ' ';
    }
}
