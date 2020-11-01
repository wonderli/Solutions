import java.util.*;
public class Solution{
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] lens = new int[n];
        int[] counts = new int[n];
        Arrays.fill(lens, 1);
        Arrays.fill(counts, 1);
        int maxLen = 0;
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(lens[j] >= lens[i]){
                        lens[i] = lens[j]+1;
                        counts[i] = counts[j];
                    }else if(lens[i] == lens[j] + 1){
                        counts[i] += counts[j];
                    }
                }
            }
            if(lens[i] == maxLen){
                res += counts[i];
            }else if(lens[i] > maxLen){
                maxLen = lens[i];
                res = counts[i];
            }
        }
        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
