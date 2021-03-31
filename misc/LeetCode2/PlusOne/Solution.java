import java.util.*;
public class Solution{
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        int len = digits.length;
        int carry = 1;
        int ret[] = new int[len];
        for(int i = len - 1; i >= 0; i--){
            ret[i] = (digits[i] + carry)%10;
            carry = (digits[i] + carry)/10;
        }
        if(carry == 1){
            int a[] = new int[len +1];
            a[0] = carry;
            for(int i = 0; i < len; i++){
                a[i+1] = ret[i];
            }
            return a;
        }
        return ret;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
