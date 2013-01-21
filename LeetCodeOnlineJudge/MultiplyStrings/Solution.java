import java.util.*;
public class Solution{
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return null;
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1 == 0 || len2 == 0) return new String("0");
        int len = 0;
        String s = null;
        String l = null;
        if(len1 > len2){
            len = len2;
            l = num1;
            s = num2;
        }else{
            len = len1;
            s = num1;
            l = num2;
        }
        StringBuilder sb = new StringBuilder();
        String ans = new String();
        String prev = multiply(s.charAt(len - 1), l);
        String curr = null;
        int carry = 0;
        for(int i = len - 2; i >= 0; i--){
           char a = s.charAt(i); 
           curr = multiply(a, l);
           StringBuilder tmp  = new StringBuilder(curr);
           int j = len - 1;
           while(j > i){
               tmp.append("0");
               j--;
           }
           prev = add(tmp.toString(), prev);
        }
        return prev;
    }
    public String multiply(char a, String b){
        if(b == null) return null;
        if(a == '0' && b != null) return new String("0");
        if(b.length() == 0) return new String("0");
        int e = Character.getNumericValue(a);
        int len = b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = len - 1; i >= 0; i--){
            int s = Character.getNumericValue(b.charAt(i));
            int result = (e * s + carry) % 10;
            sb.append(result);
            carry = (e * s + carry)/10;
        }
        if(carry != 0){
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }
    public String add(String num1, String num2){
        if(num1 == null || num2 == null) return null;
        if(num1.length() == 0) return num2;
        if(num2.length() == 0) return num1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 <= len2 ? len1 : len2;
        int i = len1 - 1;
        int j = len2 - 1;
        for(int index = len - 1; index >= 0; index--){
            int a = Character.getNumericValue(num1.charAt(i));
            int b = Character.getNumericValue(num2.charAt(j));
            int result = (a + b + carry)%10; 
            carry = (a + b + carry)/10;
            sb.append(result);
            i--;
            j--;
        }
        if(i >= 0){
            while(i >= 0){
                int a = Character.getNumericValue(num1.charAt(i));   
                int result  = (a + carry) % 10;
                carry = (a + carry)/10;
                sb.append(result);
                i--;
            }
        }
        if(j >= 0){
            while(j >= 0){
                int a = Character.getNumericValue(num2.charAt(j));   
                int result  = (a + carry) % 10;
                carry = (a + carry)/10;
                sb.append(result);
                j--;
            }
        }
        if(carry != 0){
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String a = new String("7188");
        String b = new String("102");
        //System.out.println(a);
        //System.out.println(b);
        System.out.println(sol.multiply(a, b));
        //System.out.println(sol.add("99", "9"));

    }
}
