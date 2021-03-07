import java.util.*;
class Solution2{
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        while(b <= num){
            while(i < b &&  i + b <= num){
                ans[i + b] = ans[i] + 1;
                i++;
            }
            i = 0;
            b <<= 1;
        }
        return ans;
    }
    
    public static void main(String args[]){

    }
}
