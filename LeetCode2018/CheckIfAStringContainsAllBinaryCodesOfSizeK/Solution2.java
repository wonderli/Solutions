import java.util.*;
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        Set<String> set = new HashSet<>();
        for(int i = 0; i <= s.length() - k; i++){
            String sub = s.substring(i, i+k);
            set.add(sub);
        }
        return set.size() == need;
    }
}
