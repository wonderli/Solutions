import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if(len < 3) return len;
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 2;
        while (end < len) {
            char c = s.charAt(end);
            map.put(c, end);
            end++;
            if(map.size() == 3){
                int delIndex = Collections.min(map.values());
                map.remove(s.charAt(delIndex));
                start = delIndex + 1;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String a = "eceba";
        System.out.println(sol.lengthOfLongestSubstringTwoDistinct(a));
    }
}