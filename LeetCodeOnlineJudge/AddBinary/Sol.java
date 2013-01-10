// Given two binary strings, return their sum (also a binary string).
//
// For example,
// a = "11"
// b = "1"
// Return "100". 
import java.util.*;
public class Sol{
    public String addBinary(String a, String b) {
        char ac[] = a.toCharArray();
        char bc[] = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = ac.length - 1;
        int j = bc.length - 1;
        while(i >= 0 && j >= 0){
            int av = Character.getNumericValue(ac[i]);
            int bv = Character.getNumericValue(bc[j]);
            int tmp = av + bv + carry;
            carry = 0;
            if(tmp >= 2){
                carry = 1;
                tmp = tmp - 2;
            }
            i--;
            j--;
            sb.append(tmp);
        }
        if(i >= 0 && j < 0){
            while(i >= 0){
                int av = Character.getNumericValue(ac[i]);
                int tmp = carry + av;
                carry = 0;
                if(tmp >= 2){
                    carry = 1;
                    tmp = tmp -2;
                }
                i--;
                sb.append(tmp);
            }
        }
        if(i < 0 && j >= 0){
            while(j >= 0){
                int bv = Character.getNumericValue(bc[j]);
                int tmp = carry + bv;
                carry = 0;
                if(tmp >= 2){
                    carry = 1;
                    tmp = tmp - 2;
                }
                j--;
                sb.append(tmp);
            }
        }
        if(carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
    public static void main(String args[]){
        String a = "1111";
        String b = "1111";
        Sol s = new Sol();
        System.out.println(s.addBinary(a, b));
    }
}
