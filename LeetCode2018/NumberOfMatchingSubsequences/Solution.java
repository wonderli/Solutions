import java.util.*;
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for(String w : words){
            if(match(s, w)){
                count++;
            }
        }
        return count;
    }
    
    private boolean match(String s, String w){
        int prev = 0;
        for(char c : w.toCharArray()){
            int index = s.indexOf(c, prev);
            if(index == -1){
                return false;
            }
            prev = index + 1;
        }
        return true;
    }
}
