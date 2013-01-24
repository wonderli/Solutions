//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//For example:
//Given "25525511135",
//
//return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) 
import java.util.*;
public class Solution{
    public ArrayList<String> restoreIpAddresses(String s) {
        if(s == null) return null;
        int len = s.length();
        ArrayList<String> ret = new ArrayList<String>();
        if(len < 4 || len > 12) return ret;
        String sb = new String();
        int i = 0;
        for(int j = i + 1; j < len; j++){
            for(int k = j + 1; k < len; k++){
                for(int l = k + 1; l < len; l++){
                    String a = s.substring(i, j);
                    String b = s.substring(j, k);
                    String c = s.substring(k, l);
                    String d = s.substring(l);
                    if(check(a, b, c, d)){
                        ret.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }
        return ret;
    }
    public boolean check(String a, String b, String c, String d){
        boolean lenCheck = (a.length() < 4) && (b.length() < 4) && (c.length() < 4) && (d.length() < 4);
        if(lenCheck == false) return false;
        boolean zeroCheck = (a.length() == 1 || a.charAt(0) != '0') && (b.length() == 1 || b.charAt(0) != '0') && (c.length() == 1 || c.charAt(0) != '0') && (d.length() == 1 || d.charAt(0) != '0');
        if(zeroCheck == false) return false;
        int aValue = Integer.parseInt(a);
        int bValue = Integer.parseInt(b);
        int cValue = Integer.parseInt(c);
        int dValue = Integer.parseInt(d);
        boolean vCheck = (aValue >= 0 && aValue <= 255) && (bValue >= 0 && bValue <= 255) && (cValue >= 0 && cValue <= 255) && (dValue >= 0 && dValue <= 255);
        return vCheck;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String a = "0100";
        ArrayList<String> s = sol.restoreIpAddresses(a);
        for(String e : s){
            System.out.println(e);
        }
    }
}
