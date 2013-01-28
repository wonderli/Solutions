//Implement int sqrt(int x).
//
//Compute and return the square root of x.
public class Solution{
//    This could be work, but precise might lost
//    public int sqrt(int x) {
//        int i = 0;
//        int time = 20000;
//        float guess = 2;
//        while(i < time){
//            guess = (guess + x/guess)/2;
//            i++;
//        }
//        return (int)guess;
//    }
    public int sqrt(int x){
        long l = 0;
        long r = x;
        long ret = 0;
        while(l <= r){
            long mid = l + (r - l)/2;
            long result = mid * mid;
            if(result == x){
                ret = mid;
                return (int)ret;
            }else if(result < x){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return (int)r;
    }
        public static void main(String args[]){
        Solution sol = new Solution();
        int x = 2147483647;
        //int x = 16;
        System.out.println(sol.sqrt(x));
    }
}
