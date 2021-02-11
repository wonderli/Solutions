import java.util.*;
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Integer w1 = null;
        Integer w2 = null;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            if(word1.equals(s)){
                w1 = i;
            }
            if(word2.equals(s)){
                if(word1.equals(word2)){
                    w1 = w2;
                }
                w2 = i;    
            }
            if(w1 != null && w2 != null){
                min = Math.min(min, Math.abs(w1 - w2));
            }
        }
        return min;
    }
}