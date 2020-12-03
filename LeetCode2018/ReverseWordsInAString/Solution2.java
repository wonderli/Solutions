import java.util.*;
class Solution {
    public String reverseWords(String s) {
        if(s.length() <= 1) return s;
        s = s.trim();
        char[] rs = reverse(s.toCharArray(), 0, s.length() - 1);
        int i = 0;
        int j = 0;
        int n = rs.length;
        while(j < n) {
             while(j < n && rs[j] != ' '){
                j++;
            }
            reverse(rs, i, j-1);
            while(j < n && rs[j] == ' '){
                j++;
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        i = 0;
        boolean space = false;
        while(i < n){
            if(rs[i] != ' '){
                if(space){
                    sb.append(" ");
                    space = false;
                }
                sb.append(rs[i]);
            }else{
                space = true;
            }
            i++;
        }
        return sb.toString();
    }
        
    
    private char[] reverse(char[] cs, int i, int j){
        while(i < j){
            swap(cs, i, j);
            i++;
            j--;
        }
        return cs;
    }
    private void swap(char[] cs, int i, int j){
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }
}