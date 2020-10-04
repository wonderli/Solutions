import java.util.*;
public class Solution4{
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int max = 0;
        for(int j = 0;j < s.length(); j++){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                int last = map.get(c) + 1;
                i = last > i ? last : i;
            }
            map.put(c, j);
            max= Math.max(j - i + 1, max);
        }
        return max;
    }
    public static void main(String args[]){
        Solution4 sol = new Solution4();
    }
}
