import java.util.*;
class Solution{
    public int[] countBits(int num) {
        if(num == 0) return new int[1];
        int[] ret = new int[num + 1];
        for(int i = 0; i < num + 1; i++) {
        	ret[i] = checkBits(i);
        }
        
        return ret;

    }
    public int checkBits(int n){
        int ret = 0;
        while(n > 0){
            n = n & (n - 1);
            ret++;
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int n = 5;
        System.out.println(Arrays.toString(sol.countBits(n)));
//        System.out.println(sol.checkBits(5));
    }
}
