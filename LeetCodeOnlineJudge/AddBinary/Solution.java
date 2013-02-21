import java.util.*;
public class Solution{
    public String addBinary(String a, String b) {
        if(a == null || b == null) return null;
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        int len1 = a.length();
        int len2 = b.length();
        StringBuilder sb = new StringBuilder();
        char s1[] = a.toCharArray();
        char s2[] = b.toCharArray();
        reverse(s1);
        reverse(s2);
        int carry = 0;
        int add1 = 0;
        int add2 = 0;
        int r = 0;
        for(int i = 0; i < len1; i++){
            add1 = Character.getNumericValue(s1[i]);
            add2 = (i < len2) ? Character.getNumericValue(s2[i]) : 0;
            r = (add1 + add2 + carry)%2;
            carry = (add1 + add2 + carry)/2;
            sb.append(r);
        }
        if(carry != 0){
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }
    public void reverse(char s[]){
        int i = 0;
        int j = s.length - 1;
        while(i < j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String a = "111";
        String b = "111";
        System.out.println(sol.addBinary(a, b));
    }
}
