import java.util.*;
class Solution{
    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return "";
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        String first = strs[0];
        for(int j = 0; j < first.length(); j++){
            char c = first.charAt(j);
            for(int i = 1; i < strs.length; i++){
                if(j >= strs[i].length()) return sb.toString();
                if(c != strs[i].charAt(j)) return sb.toString();
                if(i == strs.length - 1){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"aca", "cba"};
        System.out.println(sol.longestCommonPrefix(strs));
    }
}
