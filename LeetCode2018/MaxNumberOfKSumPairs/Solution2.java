import java.util.*;
public class Solution2{
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count=0;
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            if(nums[l] + nums[r] == k){
                count++;
                l++;
                r--;
            }else if(nums[l] + nums[r] < k){
                l++;
            }else{
                r--;
            }
        }
        return count;
    }
}
