import java.util.*;
class Solution{
    public int bitwiseComplement(int N) {
		if(N == 0) return 1;
        int one = 0;
        int n = N;
        int count = 0;
        while(n != 0){
            n = n >> 1;
            one = (one << 1)|1;
        }
        //System.out.println("one " + one);
        //System.out.println("one binary " + Integer.toBinaryString(one));
        return N ^ one;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int a = 5;
        System.out.println(Integer.toBinaryString(a));
        int ret = sol.bitwiseComplement(a);
        System.out.println("ret " + ret);
        System.out.println("ret binary  " + Integer.toBinaryString(ret));
    }
}
