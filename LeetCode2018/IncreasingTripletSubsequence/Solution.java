import java.util.*;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int n : nums){
            if(n <= first){
                first = n;
            }else if (n <= second){
                second = n;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {1, 2, 3, 1, 2, 1};
        System.out.println(sol.increasingTriplet(a));
    }
}
