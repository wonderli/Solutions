public class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int x = 0;
        for(int e : nums){
            x = (x << 1) | e;
        }
        if(x == 0 || k == 0) return true;
        
        while((x & 1) == 0){
            x = x >> 1;
        }
        while(x!=1){
            x = x >> 1;
            int count = 0;
            while((x & 1) == 0){
                x = x >> 1;
                count++;
            }
            if(count < k){
                return false;
            }
        }
        return true;
    }
}