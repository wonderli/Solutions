//Implement pow(x, n). 
public class Solution2{
    public double pow(double x, int n) {
        if(x == 0 && n != 0) return 0;
        if(x == 1 || n == 0) return 1;
        if(n == 1) return x;
        if(n == 2) return x * x;
        boolean flag = false;
        if(n < 0){
            flag = true;
        }
        double ret = pow(x, n/2);
        ret = ret * ret;
        if((n&1) == 1) ret *= x;
        if(flag == true) ret = 1 / ret;
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
