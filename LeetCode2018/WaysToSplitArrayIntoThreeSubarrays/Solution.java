import java.util.*;
class Solution {
    int mod = 1000000007;
    int n;
    public int waysToSplit(int[] nums) {
        n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1; i < n; i++){
            sum[i] = sum[i-1] + nums[i];
        }
        
        int res = 0;
        for(int i = 1; i < n -1; i++){
            int left = helper(sum, sum[i-1], i, true);
            int right = helper(sum, sum[i-1], i, false);
            if(left == -1 || right == -1) continue;
            res = (res + (right - left + 1) % mod) % mod;
        }
        return res;   
    }
    private int helper(int[] sum, int leftSum, int index, boolean searchLeft){
        int l = index;
        int r = n - 2;
        int res = -1;
        while(l <= r){
            int mid = l + (r - l)/2;
            int midSum = sum[mid] - sum[index - 1];
            int rightSum = sum[n-1] - sum[mid];
            if(leftSum <= midSum && midSum <= rightSum){
                res = mid;
                if(searchLeft) r = mid - 1;
                else l = mid+1;
            }else if(leftSum > midSum){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return res;
    }
}