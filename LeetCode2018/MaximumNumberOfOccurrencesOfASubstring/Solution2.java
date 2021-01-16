import java.util.*;
class Solution2 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        int i = 0;
        Map<String, Integer> map = new HashMap<>();
        Map<Character, Integer> m = new HashMap<>();
        for(int j = 0; j < n; j++){
            char c = s.charAt(j);
            m.put(c, m.getOrDefault(c, 0) + 1);
            while(j - i + 1 > minSize){
                char d = s.charAt(i);
                if(m.get(d) == 1){
                    m.remove(d);
                }else{
                    m.put(d, m.get(d) - 1);
                }
                i++;
            }
            if(m.size() <= maxLetters && j - i + 1 >= minSize){
                String sub = s.substring(i, j+1);
                map.put(sub, map.getOrDefault(sub, 0)+1);
            }
        }
        int result = 0;
        for(int e : map.values()){
            result = Math.max(result, e);
        }
        return result;
    }
}