import java.util.*;
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        int i = 0;
        int j = 0;
        while(i < len1 || j < len2){
            int a = i < len1 ? Integer.valueOf(v1[i]) : 0;
            int b = j < len2 ? Integer.valueOf(v2[j]) : 0;
            if(a < b){
                return -1;
            }else if(a > b){
                return 1;
            }else{
                i++;
                j++;
            }
        }
        return 0;
    }
}
