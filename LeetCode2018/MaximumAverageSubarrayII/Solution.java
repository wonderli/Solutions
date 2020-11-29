import java.util.*;
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxValue = Double.MIN_VALUE;
        double minValue = Double.MAX_VALUE;
        for(int n : nums){            
            maxValue = Math.max(maxValue, n);
            minValue = Math.min(minValue, n);
        }
        double prevMid = maxValue;
        double error = Double.MAX_VALUE;
        while(error > 0.00001){
            double mid = (maxValue + minValue) * 0.5;
            if(check(nums, mid, k)){
                minValue = mid;
            }else{
                maxValue = mid;
            }
            error = Math.abs(prevMid - mid);
            prevMid = mid;
        }
        return minValue;
    }
    
    private boolean check(int[] nums, double mid, int k){
        double sum = 0;
        double prev = 0;
        double minSum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i] - mid;
        }
        if(sum >= 0){
            return true;
        }
        for(int i = k; i < nums.length; i++){
            sum += nums[i] - mid;
            prev += nums[i-k] -mid;
            minSum = Math.min(prev, minSum);
            if(sum >= minSum){
                return true;
            }
        }
        return false;
    }
}