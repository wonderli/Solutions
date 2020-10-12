import java.util.*;
public class Solution3{
    public boolean isHappy(int n) {
        if(n == 0) return false;
        if(n == 1) return true;

        int a =helper(n);
        int b = helper(a);
        while(a != b){
            if(a == 1 || b == 1){
                return true;
            }
            a = helper(a);
            b = helper(helper(b));
        }
        return a == 1 || b == 1;
    }

    private int helper(int n){
        int ret = 0;
        while(n != 0){
            int a = n % 10;
            ret += a * a;
            n = n /10;
        }
        return ret;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
