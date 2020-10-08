import java.util.*;
public class Solution{
    public int lengthOfLIS(int[] nums) {
        if(nums.length < 1) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0]= 0;
        int res = 0;
        for(int i =0; i<len; i++){
            for(int j =0;j< i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] =dp[i] +1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
