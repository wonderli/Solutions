import java.util.*;
public class Solution3 {
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }
    private int helper(String s, int start, int end, int k){
        if(end < k) return 0;
        
        char[] map = new char[26];
        for(int i = start; i < end; i++){
            map[s.charAt(i) - 'a']++;
        }

        for(int mid = start ; mid < end; mid++){
            if(map[s.charAt(mid) - 'a'] >= k) continue;
            
            int midNext = mid + 1;
            while(midNext < end && map[s.charAt(midNext) - 'a'] < k) midNext++;
            return Math.max(helper(s, start, mid, k), helper(s, midNext, end, k));
        }
        return end - start;
    }
}
