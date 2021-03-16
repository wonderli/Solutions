import java.util.*;
class Solution2{
    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return "";
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        String first = strs[0];
        for(int i = 0; i < first.length(); i++){
            char c = first.charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i >= strs[j].length()) return sb.toString();
                if(c != strs[j].charAt(i)) return sb.toString();
                if( j == strs.length - 1){
                    sb.append(c);
                }
            }
        }
        return sb.toString();

    }

    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}