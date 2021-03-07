import java.util.*;
class Solution3{
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for(int i = 1; i < num + 1; i++){
            ans[i] = ans[i & (i-1)] + 1;
        }
        return ans;
    }
    
    public static void main(String args[]){
    }
}

