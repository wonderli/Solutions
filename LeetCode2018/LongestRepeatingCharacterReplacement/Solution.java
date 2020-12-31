import java.util.*;
class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0;
        int maxRepeat = 0;
        int max = 0;
        for(int j = 0; j < n; j++){
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxRepeat = Math.max(maxRepeat, map.get(c));
            if(j - i + 1 - maxRepeat > k){
                char remove = s.charAt(i);
                map.put(remove, map.get(remove)-1);
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}