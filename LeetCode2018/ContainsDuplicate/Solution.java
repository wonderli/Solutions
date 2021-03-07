import java.util.*;
class Solution{
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        Arrays.sort(nums);
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]) {
                count++;
            }else {
                count = 1;
            }
            if(count >= 2){
                return true;
            }
        }
        return false;

    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
