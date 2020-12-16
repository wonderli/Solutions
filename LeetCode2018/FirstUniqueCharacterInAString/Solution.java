import java.util.*;
class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        int n = s.length(); 
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(map[c - 'a'] == -1){
                map[c- 'a'] = i;
            }else{
                map[c - 'a'] = n;
            }
        }
        int min = n;
        for(int i = 0; i < 26; i++){
            if(map[i] != -1 && map[i] < n){
                min = Math.min(min, map[i]);
            }
        }
        return min == n ? -1 : min;
    }
}