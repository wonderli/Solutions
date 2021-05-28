import java.util.*;
class Solution {
    public int maxProduct(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String w : words){
            map.put(w, getInt(w));
        }
        int max = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < i; j++){
                if(!overlap(words[i], words[j], map)){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
    
    private boolean overlap(String a, String b, Map<String, Integer> map){
        int p = map.get(a);
        int q = map.get(b);
        return (p & q) != 0;
    }
    private int getInt(String w){
        int result = 0;
        for(char c : w.toCharArray()){
            int v = c - 'a' - 1;
            if((result & (1 << v)) == 0){
                result |= (1 << v);
            }
        }
        return result;
    }
}