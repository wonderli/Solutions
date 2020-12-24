import java.util.*;
class Solution {
    public int nextGreaterElement(int n) {
        char[] s = Integer.toString(n).toCharArray();
        int len = s.length;
        int i = len - 2;
        while(i >=0 && s[i] >= s[i+1]){
            i--;
        }
        if(i < 0) return -1;
        int j = len - 1;
        while(s[j] <= s[i]){
            j--;
        }
        swap(s, i, j);
        int l = i +1;
        int r = len - 1;
        while(l < r){
            swap(s, l, r);
            l++;
            r--;
        }
        long v = Long.valueOf(new String(s));
        if(v > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) v;
    }
    private void swap(char[] s, int i, int j){
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
}