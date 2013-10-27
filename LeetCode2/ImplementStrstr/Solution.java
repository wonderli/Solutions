import java.util.*;
public class Solution{
    public String strStr(String haystack, String needle) {
        if(haystack == null) return null;
        if(needle == null) return null;
        if(needle.length() == 0) return haystack;
        int hLen = haystack.length();
        int nLen = needle.length();
        int last = 0;
        int i = 0;
        int j = 0;
        while(i < hLen && j < nLen){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++; 
                j++;
            }else{
                last++;
                j = 0;
                i = last;
            }
            if(j == nLen) return haystack.substring(last);
        }
        if(i == hLen && j == nLen)
            return haystack.substring(hLen - nLen);
        return null;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String h = "";
        String n = "";
        System.out.println(sol.strStr(h, n));
    }
}
