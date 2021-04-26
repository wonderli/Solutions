import java.util.*;

class Solution {
    public int solve(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        int result = 0;
        for(String s : words){
            String prev = s.substring(0, s.length() - 1);
            map.put(s, map.getOrDefault(prev, 0) + 1);
            result = Math.max(result, map.get(s));
        }
        return result;
    }
}