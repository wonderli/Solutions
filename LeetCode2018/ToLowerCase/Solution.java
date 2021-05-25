import java.util.*;
class Solution {
    public String toLowerCase(String s) {
        if(s == null || s.length() == 0) return s;
        char[] cs= s.toCharArray();
        for(int i = 0; i < cs.length; i++){
            char c = cs[i];
            if('A' <= c && c <= 'Z'){
                cs[i] = (char)(c - 'A' + 'a');
            }
        }
        return new String(cs);
    }
}
