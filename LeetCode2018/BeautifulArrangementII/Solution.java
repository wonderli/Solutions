import java.util.*;
class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for(int i = 0, l = 1, r = n; l <= r; i++){
            if(k > 1){
                if(k % 2 != 0){
                    res[i] = l;
                    l++;
                }else{
                    res[i] = r;
                    r--;
                }
                k--;
            }else{
                res[i] = l;
                l++;
            }
        }
        return res;
    }
}