import java.util.*;
class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        String a = num1.length() > num2.length() ? num1 : num2;
        String b = num1.length() > num2.length() ? num2 : num1;
        
        // System.out.println("a " +a);
        // System.out.println("b " + b);
        String base = "0";
        int count = 0;
        for(int i = b.length() - 1; i>= 0; i--){
            char c= b.charAt(i);
            String t = mul(c, a);
            for(int x = 0; x < count; x++){
                t = t + "0";
            }
            String sum = add(t, base);
            // System.out.println(sum);
            base = sum;
            count++;
        }
        String res = strip(base);
        return res;
    }
    
    private String strip(String a){
        boolean allZero = true;
        for(char c : a.toCharArray()){
            if(c != '0'){
                allZero = false;
                break;
            }
        }
        return allZero ? "0" : a;
    }
    
    private String add(String a, String b){
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 || j >= 0){
            int p = i >= 0 ? a.charAt(i) - '0' : 0;
            int q = j >= 0? b.charAt(j) - '0' : 0;
            int sum = p + q + carry;
            result.append(sum%10);
            carry = sum/10;
            i--;
            j--;
        }
        if(carry != 0){
            result.append(carry);
        }
        return result.reverse().toString();
        
    }
    
    private String mul(char c, String a){
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int carry = 0;
        while(i >= 0){
            char p = a.charAt(i);
            int t = (p - '0') * (c - '0') + carry;
            result.append(t%10);
            carry = t/10;
            i--;
        }
        if(carry != 0){
            result.append(carry);
        }
        return result.reverse().toString();
    }
    
}
