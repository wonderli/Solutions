import java.util.*;
public class Solution{
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1] - nums[0];
        while(l < r){
            int mid = l + (r - l)/2;
            int tmp = findDistanceCount(nums, mid);
            if(tmp >= k){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    public int findDistanceCount(int[] nums, int mid){
        int count = 0;
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            while(nums[j] - nums[i] > mid && i < j){
                i++;
            }
            count += j - i;
        }
        return count;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
