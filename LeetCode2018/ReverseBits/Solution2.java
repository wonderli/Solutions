import java.util.*;
public class Solution2{
    public int reverseBits(int n) {
        int a = 0;
        while(n != 0){
            a = a << 1;
            a = a | (n & 1);
            n = n >> 1;
        }
        return a;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
