import java.util.*;
class Solution {
    public int minPartitions(String n) {
        if(n == null || n.length() == 0) return 0;
        int result = 1;
        for(char c : n.toCharArray()){
            result = Math.max(result, Character.getNumericValue(c));
        }
        return result;
    }
}