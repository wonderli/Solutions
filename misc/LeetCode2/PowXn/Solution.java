import java.util.*;
public class Solution{
    public double pow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        boolean isNeg = false;
        if(n < 0) {
            n = -n;
            isNeg = true;
        }
        double r = pow(x, n/2);
        double m = pow(x, n%2);
        return isNeg == true ? 1/(r * r * m) : r * r * m;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
