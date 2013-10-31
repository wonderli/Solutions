import java.util.*;
public class Solution{
    public String multiply(String num1, String num2) {
        if(num1 == null||num1.length() == 0) return num2;
        if(num2 == null||num2.length() == 0) return num1;
        int len = num2.length();
        String ret = mul(num1, num2.charAt(len - 1));
        int factor = 1;
        for(int i = len-2; i >= 0; i--){
            String o = mul(num1, num2.charAt(i));
            for(int j = 0; j <factor; j++){
                o += '0';
            }
            ret = add(ret, o);
            factor++;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int i = 0; i < ret.length(); i++){
            if(ret.charAt(i) != '0' && flag == true){
                flag = false;
                sb.append(ret.charAt(i));
            }else if(flag == false){
                sb.append(ret.charAt(i));
            }
        }
        ret = sb.toString();
        if(sb.length() == 0) return "0";
        return ret;
    }
    public String add(String a, String b){
        int aLen = a.length();
        int bLen = b.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = aLen - 1, j = bLen - 1; i >= 0 || j >= 0; i--, j--){
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int r = (x + y + carry)%10;
            carry = (x + y + carry)/10;
            sb.append(r);
        }
        if(carry != 0) sb.append(carry);
        sb.reverse();
        return sb.toString();
    }
    public String mul(String a, char c){
        int len = a.length();
        int carry = 0;
        int num = c - '0';
        StringBuilder sb = new StringBuilder();
        for(int i = len - 1; i >= 0; i--){
            int x = a.charAt(i) - '0';
            int r = (x * num + carry)%10;
            carry = (x * num + carry)/10;
            sb.append(r);
        }
        if(carry != 0) sb.append(carry);
        sb.reverse();
        return sb.toString();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.multiply("9133", "0"));
    }
}
