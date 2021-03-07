import java.util.*;
public class Solution{
    public int smallestRepunitDivByK(int K) {
        if(K%2 == 0 || K%5 == 0) return -1;
        int remainder = 0;
        for(int i = 1; i <= K; i++){
            remainder = (remainder * 10 + 1) %K;
            if(remainder == 0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
