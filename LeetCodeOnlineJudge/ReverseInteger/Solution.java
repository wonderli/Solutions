//Reverse digits of an integer.
//
//Example1: x = 123, return 321
//Example2: x = -123, return -321 
public class Solution{
    public int reverse(int x) {
        boolean neg = false;
        if(x < 0){
            neg = true;
            x = -x;
        }
        int r = 0;
        while(x != 0){
            r = r * 10 + x%10;
            x = x / 10;
        }
        if(neg){
            return -r;
        }
        return r;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int x = 123;
        System.out.println(sol.reverse(x));
    }
}
