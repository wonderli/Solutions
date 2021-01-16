import java.util.*;
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> count = new HashMap<>();
        for(int i = 0; i + minSize <= s.length(); i++){
            String tmp = s.substring(i, i + minSize);
            Set<Character> letter = new HashSet<>();
            for(char c :  tmp.toCharArray()){
                letter.add(c);
            }
            if(letter.size() > maxLetters) continue;
            count.put(tmp, count.getOrDefault(tmp, 0) +1);
        }
        int max = 0;
        for(String e : count.keySet()){
            int cnt = count.get(e);
            max = Math.max(max, cnt);
        }
        return max;
    }
}