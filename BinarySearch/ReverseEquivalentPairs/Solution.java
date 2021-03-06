import java.util.*;

class Solution {
    public int solve(int[] nums) {
        Map<Long, Long> map = new HashMap<>();
        int mod = (int)1e9+7;
        int n = nums.length;
        long result = 0;
        for(int i = 0; i < nums.length; i++){
            long a = (int)nums[i];
            long ra = rev(a);
            map.put(a - ra, map.getOrDefault(a - ra, 0L) + 1);
            result = (result + map.get(a - ra)) % mod;
        }
        return (int)result;

    }

    private long rev(long num){
        long ret = 0;
        while(num != 0){
            ret = ret * 10 + num % 10;
            num = num/10;
        }
        return ret;
    }
}