import java.util.*;
class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        Set<Integer> used = new HashSet<>();
        int count = 0;
        for(int i = 0; i < 26; i++){
            int v = freq[i];
            while(v > 0 && used.contains(v)){
                v--;
                count++;
            }
            used.add(v);
        }
        return count;
    }
}
