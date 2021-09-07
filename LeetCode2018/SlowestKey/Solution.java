import java.util.*;
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int[] diff = new int[n];
        diff[0] = releaseTimes[0];
        for(int i = 1; i < n; i++){
            diff[i] = releaseTimes[i] - releaseTimes[i-1];
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        char maxC = 'a';
        for(int i = 0; i < n; i++){
            char c = keysPressed.charAt(i);
            int e = map.getOrDefault(c, 0);
            int curr = diff[i];
            map.put(c, Math.max(curr, e));

            if(map.get(c) > max){
                max = map.get(c);
                maxC = keysPressed.charAt(i);
            }else if(map.get(c) == max) {
                if(keysPressed.charAt(i) > maxC){
                    maxC = keysPressed.charAt(i);
                }
            }
        }
        return maxC;
        
    }
}
