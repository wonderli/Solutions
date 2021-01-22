import java.util.*;
import java.util.*;
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        Map<Character, Integer> map1 = collect(word1);
        Map<Character, Integer> map2 = collect(word2);
        if(!map1.keySet().equals(map2.keySet())) return false;
        List<Integer> m1 = sort(map1);
        List<Integer> m2 = sort(map2);
        return m1.equals(m2);
    }
    private Map<Character, Integer> collect(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
    private List<Integer> sort(Map<Character, Integer> map){
        Collection<Integer> v = map.values();
        List<Integer> list = new ArrayList<>(v);
        Collections.sort(list);
        return list;
    }
}

