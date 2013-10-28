import java.util.*;
public class Solution{
    public int atoi(String s) {
        if(s == null || s.length() == 0) return 0;
        boolean isNeg = false;
        int len = s.length();
        int start = 0;
        int end = len - 1;
        while(start < end && (s.charAt(start) == ' ')) start++;
        while(start < end && (s.charAt(end) == ' ')) end--;
        if(s.charAt(start) == '-'){
            isNeg = true;
            start++;
        }else if(s.charAt(start) == '+'){
            start++;
        }
        int i = start;
        long ret = 0;
        while(i <= end){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                ret = ret * 10 + (s.charAt(i) - '0');
            }else break;
            i++;
        }
        if(isNeg) ret = -ret;
        if(ret > Integer.MAX_VALUE) ret = Integer.MAX_VALUE;
        if(ret < Integer.MIN_VALUE) ret = Integer.MIN_VALUE;
        return (int)ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
