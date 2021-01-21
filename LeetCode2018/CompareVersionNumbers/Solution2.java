import java.util.*;
public class Solution2 {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int i = 0;
        int j = 0;
        while(i < len1 || j < len2){
            String a = getNext(version1, i);
            String b = getNext(version2, j);
            int v1 = a.length() != 0 ? Integer.valueOf(a) : 0;
            int v2 = b.length() != 0 ? Integer.valueOf(b) : 0;
            if(v1 < v2){
                return -1;
            }else if(v1 > v2){
                return 1;
            }else{
                i = i + a.length() + 1;
                j = j + b.length() + 1;
            }
        }
        return 0;
    }
    private String getNext(String s, int start){
        int n = s.length();
        if(start >= n) return "";
        
        int j = start+1;
        while(j < n && s.charAt(j) != '.'){
            j++;
        }
        return s.substring(start, j);
    }
}
