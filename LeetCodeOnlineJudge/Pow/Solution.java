//Implement pow(x, n). 
public class Solution{
    // Easy solution
    /*
    public double pow(double x, int n) {
        if(x == 0 && n != 0) return 0;
        if(x == 1 || n == 0) return 1;
        if(n == 1) return x;
        if(n == 2) return x * x;
        if(n < 0){
            n = -n;
            return 1/(pow(x, n/2) * pow(x, n/2) * pow(x, n%2));
        }
        return pow(x, n/2) * pow(x, n/2) * pow(x, n%2);
    }
    */
    public double pow(double x, int n){
        boolean flag = false;
        if(n < 0) {
            n = -n;
            flag = true;
        }
        if(n == 0){
            return 1;
        }
        double pow = x;
        double r = 1.0;
        //1 2 4 8
        while(n > 0){
            if(n % 2 == 1){
                r *= pow;
            }
            pow *= pow;
            n = n/2;
        }
        if(flag) return 1/r;
        return r;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
