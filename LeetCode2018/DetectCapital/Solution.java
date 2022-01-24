import java.util.*;
class Solution {
    public boolean detectCapitalUse(String word) {
        boolean first = Character.isUpperCase(word.charAt(0));
        int cap = 0;
        for(int i = 1; i < word.length(); i++){
            char c = word.charAt(i);
            if(Character.isUpperCase(c)){
                cap++;
            }
        }
        return (!first && (cap == 0)) || (first && cap == word.length() - 1) ||(first && (cap == 0));
    }
}
