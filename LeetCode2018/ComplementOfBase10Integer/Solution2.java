import java.util.*;
public class Solution2{
    public int bitwiseComplement(int N){
        if(N == 0) return 1;
        int n = N;
        int bit = 1;
        while(n != 0){
            N = N ^ bit;
            bit = bit << 1;
            n = n >> 1;
        }
        return N;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
