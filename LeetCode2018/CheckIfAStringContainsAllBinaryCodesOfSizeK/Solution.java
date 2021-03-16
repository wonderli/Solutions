import java.util.*;
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        boolean[] got = new boolean[need];
        int allOne = need - 1;
        int hashValue = 0;
        for(int i =0 ;i < s.length(); i++){
            hashValue = ((hashValue << 1) & allOne) | (s.charAt(i) - '0');
            if(i >= k-1 && !got[hashValue]){
                got[hashValue] = true;
                need--;
                if(need == 0){
                    return true;
                }
            }
        }
        return false;
    }
}