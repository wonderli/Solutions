import java.util.*;
public class Solution {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();        
        for(int i = 0; i < keyboard.length(); i++){
            map.put(keyboard.charAt(i), i);
        }
        int count = 0;
        int start = 0;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = map.get(c);
            count += Math.abs(index - start);
            start = index;
        }
        return count;
    }
}
