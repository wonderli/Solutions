import java.util.*;
public class Solution4{
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        int hLen = haystack.length();
        int nLen = needle.length();
        if(nLen == 0) return 0;
        int i = 0;
        while( i < hLen - nLen + 1){
            while(i < hLen - nLen + 1 && haystack.charAt(i) != needle.charAt(0)) i++;
            int currLen = 0;
            int j = 0;
            while(j < nLen && i < hLen && haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                currLen++;
            }
            if(currLen == nLen) return i - nLen;
            i = i - currLen + 1;
        }
        return -1;
    }

    public static void main(String args[]){

        Solution4 sol = new Solution4();
    }
}
