import java.util.*;
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            char a = cs[l];
            char b = cs[r];
            if(!Character.isLetter(a)){
                l++;
            }else if(!Character.isLetter(b)){
                r--;
            }else if(Character.isLetter(a) && Character.isLetter(b)){
                swap(cs, l, r);
                l++;
                r--;
            }
        }
        return new String(cs);
    }
    private void swap(char[] cs, int i, int j){
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }
}
