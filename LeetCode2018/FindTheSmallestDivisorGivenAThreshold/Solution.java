import java.util.Arrays;

class Solution {
    int res = 0;
    public int smallestDivisor(int[] nums, int threshold) {
        int len = nums.length;
        if(len == 1){
            return nums[0]/threshold + (nums[0]%threshold == 0 ? 0 : 1);
        }
        Arrays.sort(nums);
        res = Integer.MAX_VALUE;

        helper(nums, 1, nums[len -1], threshold);
        return res;
    }

    private void helper(int[] nums, int l, int r, int threshold){
        if(l > r) return;

        int mid = l + (r - l)/2;


        int sum = getSum(nums, mid);
        if(sum <= threshold){
            res = Math.min(mid, res);
            helper(nums, l, mid - 1, threshold);
        }else{
            helper(nums, mid+1, r, threshold);
        }
    }

    private int getSum(int[] nums, int d) {

        int count = 0;
        for(int n : nums){
            count += n/d + (n%d  == 0 ? 0:1);
        }
        return count;
    } 

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {91,41,78,86,8};
        int t = 114;
        System.out.println(sol.smallestDivisor(a, t));
    }

}