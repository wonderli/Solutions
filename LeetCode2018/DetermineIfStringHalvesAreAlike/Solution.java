import java.util.*;
class Solution {
    Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                count += i >= n/2 ? -1 : 1;
            }
        }
        
        return count == 0;
    }
}
