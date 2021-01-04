import java.util.*;
class Solution {
    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0;
        int j = 1;
        int len = 0;
        while(j + len < n){
            if(s.charAt(i + len) == s.charAt(j + len)){
                len++;
            }else if(s.charAt(i + len) > s.charAt(j + len)){
                j = j + len + 1;
                len = 0;
            }else {
                i = Math.max(i + len + 1, j);
                j = i + 1;
                len = 0;
            }
        }
        return s.substring(i);
    }
}