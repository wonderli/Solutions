//Divide two integers without using multiplication, division and mod operator.
public class Solution{
    public int divide(int dividend, int divisor) {
        if(divisor == 0) throw new ArithmeticException();
        long a = dividend;
        a = Math.abs(a);
        long b = divisor;
        b = Math.abs(b);
        int c = 0;
        int ret = 0;
        while((b << c) <= a){
            c++;
        }
        while(c >= 0){
            if((b << c) <= a ){
                a -= b << c;
                ret |= 1 << c;
            }
            c--;
        }
        boolean neg = false;
        if(dividend < 0){
            neg = !neg;
        }
        if(divisor < 0){
            neg = !neg; 
        } 
        return neg ? -ret : ret; 
    }
    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.divide(25,5));
    }
}
