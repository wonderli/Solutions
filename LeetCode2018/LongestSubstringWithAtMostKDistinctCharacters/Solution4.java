import java.util.*;
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k < 1) return 0;
        int n = s.length();
        int[] map = new int[256];
        int i = 0;
        int j = 0;
        int max = 0;
        int count = 0;
        while(j < n){
            if(map[s.charAt(j)] == 0){
                count++;
            }
            map[s.charAt(j)]++;
            while(i < j && count > k){
                map[s.charAt(i)]--;
                if(map[s.charAt(i)] == 0){
                    count--;
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}
