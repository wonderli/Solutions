import java.util.*;
public class Solution2 {
    public int longestSubstring(String s, int k) {
        if (k > s.length()) return 0;
        Map<Character, Integer> count = new HashMap<>();
        for (char c: s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        Set<Character> set = new HashSet<>();
        for (Character c: count.keySet()) {
            if (count.get(c) < k) {
                set.add(c);
            }
        }
        if (set.isEmpty()){
             return s.length();
        }
        int res = 0;
        int start = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || set.contains(s.charAt(i))) {
                int subMax = longestSubstring(s.substring(start, i), k);
                res = Math.max(subMax, res);
                start = i + 1;
            }
        }
        return res;
    }
}
