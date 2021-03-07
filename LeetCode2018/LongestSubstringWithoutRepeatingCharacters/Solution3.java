import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;
        int lastStart = 0;
        for(int i = 0; i < s.length(); i++){
            char key = s.charAt(i);
            if(map.containsKey(key)){
                int index = map.get(key);
                map.put(key, i);
                lastStart = index > lastStart ? index : lastStart;
                count = i - lastStart;
            }else {
                map.put(key, i);
                count++;
            }
            max = Math.max(max, count);
        }
        return max;

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(sol.lengthOfLongestSubstring("abcabcdbb"));
        System.out.println(sol.lengthOfLongestSubstring("abba"));

    }
}