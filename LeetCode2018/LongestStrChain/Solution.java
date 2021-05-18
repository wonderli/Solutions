import java.util.*;
class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        int result = 0;
        for(String w : words){
            int best = 0;
            for(int i = 0; i < w.length(); i++){
                String prev = w.substring(0, i) + w.substring(i+1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(w, best);
            result = Math.max(result, best);
        }
        return result;
    }
}
