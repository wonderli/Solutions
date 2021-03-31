import java.util.*;
public class Solution{
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int ret = 0;
        int len = s.length();
        for(int i = 0; i < len - 1; i++){
            int a = num(s.charAt(i));
            int b = num(s.charAt(i+1));
            if(a >= b){
                ret += a;
            }else{
                ret -= a;
            }
        }
        ret += num(s.charAt(len - 1));
        return ret;
    }
    public int num(char c){
        int ret = 0;
        switch (c) {
            case 'I':
                ret = 1;
                break;
            case 'V':
                ret = 5;
                break;
            case 'X':
                ret = 10;
                break;
            case 'L':
                ret = 50;
                break;
            case 'C':
                ret = 100;
                break;
            case 'D':
                ret = 500;
                break;
            case 'M':
                ret = 1000;
                break;
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
