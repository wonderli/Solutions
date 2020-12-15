import java.util.*;
public class Solution{
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int val = len * (len + 1)/ 2;
        int actual = 0;
        for(int i = 0; i < len; i++){
            actual += nums[i];
        }
        return Math.abs(actual - val);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
