import java.util.*;
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            
            if(sMap.containsKey(sc) && tMap.containsKey(tc)){
                int sIndex = sMap.get(sc);
                int tIndex = tMap.get(tc);
                if(sIndex != tIndex){
                    return false;
                }
            }else if(!sMap.containsKey(sc) && !tMap.containsKey(tc)){
                sMap.put(sc, i);
                tMap.put(tc, i);
            }else{
                return false;
            }
        }
        return true;
    }
}