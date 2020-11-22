import java.util.*;
class Solution {
    String[] dict = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    
    public int uniqueMorseRepresentations(String[] words) {
        if(words.length == 0) return 0;
        Set<String> res = new HashSet<>();
        
        for(String w :words){
            StringBuilder sb = new StringBuilder();
            for(char c : w.toCharArray()){
                sb.append(dict[c - 'a']);
            }
            res.add(sb.toString());
        }
        return res.size();
    }

}