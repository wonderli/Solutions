import java.util.*;
public class Solution2{
    public int longestConsecutive(int[] nums){
        Set<Long> set = new HashSet<>();
        for(int n : nums){
            set.add((long)n);
        }
        int res = 0;
        for(long n : set){
            if(!set.contains(n-1)){
                long curr = n;
                int currNumber = 1;
                while(set.contains(curr+1)){
                    curr++;
                    currNumber++;
                }
                res = Math.max(res, currNumber);
            }
        }
        return res;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
