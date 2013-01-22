//Given a number represented as an array of digits, plus one to the number.
import java.util.*;
public class Solution{
    public int[] plusOne(int[] digits) {
        if(digits == null) return null;
        if(digits.length == 0) {
            int ans[] = new int[1];
            ans[0] = 1;
            return ans;
        }
        int len = digits.length;
        int carry = 0;
        int a = 1;
        for(int i = len - 1; i >= 0; i--){
            int r = (digits[i] + a + carry)%10;
            carry = (digits[i] + a + carry)/10;
            a = 0;
            digits[i] = r;
        }
        if(carry != 0){
            int ans[] = new int[len + 1];
            ans[0] = carry;
            for(int i = 0; i < len; i++){
                ans[i+1] = digits[i]; 
            }
            return ans;
        }
        return digits;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int a[] = {9, 9, 9, 8};
        //System.out.println(Arrays.toString(a));
        int b[] = sol.plusOne(a);
        //System.out.println(Arrays.toString(b));
    }
}
