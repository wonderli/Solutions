import java.util.*;
public class Solution3 {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1) return 1;
        if(n == 1) return x;
        if(n == Integer.MIN_VALUE) return  1 / (myPow(x, Integer.MAX_VALUE) * x);
        if(n < 0) return 1/myPow(x, -n);

        double tmp = myPow(x, n/2);
        return n % 2 == 1 ? tmp * tmp * x : tmp * tmp;
    }
}
