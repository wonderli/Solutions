import java.util.*;
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for(char c : order.toCharArray()){
            map.put(c, i);
            i++;
        }
        for(i = 1; i < words.length; i++){
            String prev = words[i-1];
            String curr = words[i];
            if(compare(prev, curr, map) > 0){
                return false;
            }
        }
        return true;
    }
    
    private int compare(String prev, String curr, Map<Character, Integer> map){
        int i = 0;
        int j = 0;
        while(i < prev.length() && j < curr.length()){
            char p = prev.charAt(i);
            char c = curr.charAt(j);
            int indexP = map.get(p);
            int indexC = map.get(c);
            if(indexP > indexC){
                return 1;
            }else if(indexP < indexC){
                return -1;
            }else{
                i++;
                j++;
            }
        }
        if(curr.length() < prev.length()){
            return 1;
        }
        return -1;
    }
}