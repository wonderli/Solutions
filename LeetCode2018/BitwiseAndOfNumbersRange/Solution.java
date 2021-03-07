import java.util.*;
class Solution{
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while(m < n){
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.rangeBitwiseAnd(5, 7));
    }
}
