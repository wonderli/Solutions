import java.util.*;
public class Solution{
    public int sqrt(int x) {
        if(x <= 1) return x;
        long l = 0;
        long r = x;
        while(l <= r){
            long mid = l + (r - l)/2;
            long curr = mid * mid;
            if(curr == x){
                return (int)mid;
            }else if(curr > x){
                r = mid - 1;
            }else l = mid + 1;
        }
        return (int)r;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.sqrt(8));
    }
}
