import java.util.*;
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> result = new ArrayList<>();
        for(String w : words){
            if(match(w, pattern)){
                result.add(w);
            }
        }
        return result;
    }
    private boolean match(String a, String b){
        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();
        for(int i = 0; i < a.length(); i++){
            char ac = a.charAt(i);
            char bc = b.charAt(i);
            if(aMap.containsKey(ac) && bMap.containsKey(bc)){
                int p = aMap.get(ac);
                int q = bMap.get(bc);
                if(p != q){
                    return false;
                }
            }else if(!aMap.containsKey(ac) && !bMap.containsKey(bc)){
                aMap.put(ac, i);
                bMap.put(bc, i);
            }else{
                return false;
            }
        }
        return true;
    }
}