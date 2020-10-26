import java.util.*;
public class Solution3{
    public int longestConsecutive(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        int res = 0;
        for(int n : nums){
            long nl = (long)n;
            if(!map.containsKey(nl)){
                int left = 0;
                int right = 0;
                int sum = 0;
                if(map.containsKey(nl -1)){
                    left = map.get(nl-1);
                }else{
                    left = 0;
                }
                if(map.containsKey(nl + 1)){
                    right = map.get(nl + 1);
                }else{
                    right = 0;
                }
                sum = left + right + 1;
                map.put(nl, sum);
                res = Math.max(res, sum);
                map.put(nl - (long)left, sum);
                map.put(nl + (long)right, sum);
            }
        }
        return res;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
