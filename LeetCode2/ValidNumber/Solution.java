import java.util.*;
public class Solution{
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        int len = s.length();
        int start = 0;
        int end = len - 1;
        while(start < end && s.charAt(start) == ' ') start++;
        while(start < end && s.charAt(end) == ' ') end--;
        s = s.substring(start, end+1);
        s = s.toLowerCase();
        if(checkInteger(s, true)) return true;
        if(checkFloat(s)) return true;
        if(checkSci(s)) return true;
        return false;
    }
    public boolean checkInteger(String s, boolean flag){
        if(s.length() == 0) return !flag;
        int len = s.length();
        if(len == 1) return Character.isDigit(s.charAt(0));
        for(int i = 0; i < len; i++){
            if(flag == true && i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-')) continue;
            if(Character.isDigit(s.charAt(i))) continue;
            else return false;
        }
        return true;
    }
    public boolean checkFloat(String s){
        if(s == null || s.length() == 0) return false;
        if(s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
        if(s.indexOf('+') != -1 || s.indexOf('-') != -1) return false;
        int dotPos = s.indexOf('.');
        if(dotPos == -1) return false;
        if(dotPos == 0 && s.length() == 1) return false;
        else if(dotPos == 0 && s.length() > 1) return checkInteger(s.substring(1), false);
        else {
            String a = s.substring(0, dotPos);
            String b = s.substring(dotPos + 1);
            return checkInteger(a, true) && checkInteger(b, false);
        }
    }
    public boolean checkSci(String s){
        if(s == null || s.length() == 0) return false;
        int ePos = s.indexOf('e');
        if(ePos == -1) return false;
        String a = s.substring(0, ePos);
        String b = s.substring(ePos+1);
        if(b.length() == 0) return false;
        int dotPos = a.indexOf('.');
        if(dotPos != -1) return checkFloat(a) && checkInteger(b, true);
        else{
            return checkInteger(a, true) && checkInteger(b, true);
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String a = "40.e3";//true
        String b = "2e10"; //true
        String c = "005047e+6"; //true
        System.out.println(sol.checkSci(b));
        System.out.println(sol.checkInteger("2", true));
        System.out.println(sol.checkSci(c));
    }
}
