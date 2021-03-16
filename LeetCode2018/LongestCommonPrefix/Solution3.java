import java.util.*;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String prefix = strs[0];
        for(String s : strs){
            prefix = common(s, prefix);
        }
        return prefix;
    }
    private String common(String a, String prefix){
        int i = 0;
        int j = 0;
        while(i < a.length() && j < prefix.length()){
            if(a.charAt(i) == prefix.charAt(j)){
                i++;
                j++;
            }else{
                break;
            }
        }
        return j == 0 ? "" : prefix.substring(0, j);
    }
}
