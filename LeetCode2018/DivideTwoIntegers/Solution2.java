import java.util.*;
class Solution2 {
    public int divide(int dividend, int divisor) {
        boolean isNegative = false;
        if(dividend < 0){
            isNegative = !isNegative;
        }

        if(divisor < 0){
            isNegative = !isNegative;
        }

        int d1 = dividend < 0 ? dividend : - dividend;
        int d2 = divisor < 0 ? divisor : -divisor;

        int result = 0;
        while(d1 <= d2){
            int curr = -1;
            int v = d2;
            while(v >= Integer.MIN_VALUE/2 && v + v >= d1){
                v +=v;
                curr += curr;
            }
            result += curr;
            d1 = d1 - v;
        }
        if(!isNegative){
            if(result == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return -result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int d1 = 100;
        int d2 = 2;
        System.out.println(sol.divide(d1, d2));
    }
}