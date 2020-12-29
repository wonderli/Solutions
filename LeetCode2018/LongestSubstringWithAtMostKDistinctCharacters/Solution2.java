import java.util.*;
public class Solution2{
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while(end < n){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0)+1);
            end++;
            while(map.size() > k){
                c = s.charAt(start);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) -1);
                    if(map.get(c) == 0){
                        map.remove(c);
                    }
                }
                start++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}