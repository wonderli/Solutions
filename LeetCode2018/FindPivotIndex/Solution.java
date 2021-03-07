import java.util.*;
class Solution{
    public int pivotIndex(int[] nums) {
        if(nums == null) return -1;
        int[] sumLeft = new int[nums.length];
        int lSum = 0;
        for(int i = 1; i < nums.length; i++){
          sumLeft[i] = lSum + nums[i - 1];
          lSum = sumLeft[i];
        }
        int[] sumRight = new int[nums.length];
        int rSum = 0;
        for(int i = nums.length - 2; i >= 0; i--){
            sumRight[i] = rSum + nums[i + 1];
            rSum = sumRight[i];
        }
        for(int i = 0; i < nums.length; i++){
            if(sumLeft[i] == sumRight[i]){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] a = {1,7,3,6,5,6};
        System.out.println(sol.pivotIndex(a));
        int[] b = {1, 2, 3};
        System.out.println(sol.pivotIndex(b));

    }
}
