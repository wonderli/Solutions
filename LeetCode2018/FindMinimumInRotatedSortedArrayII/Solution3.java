import java.util.*;
public class Solution3{
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] >nums[r]){
                l = mid +1;
            }else if(nums[mid] == nums[r]){
                r = r-1;
            }else{
                r = mid;
            }
        }

        return nums[l];
    }

    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
