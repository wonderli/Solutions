import java.util.*;
public class Solution{
    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        int ret = 0;
        while(a != 0){
            a = a & (a - 1);
            ret++;
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.hammingDistance(1, 4));
    }
}
