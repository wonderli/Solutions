import java.util.*;
public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int j = n - 1;
        while(j >= 1 && nums[j] <= nums[j-1]){
            j--;
        }
        if(j == 0){
            reverse(nums, 0, n-1);
            return;
        }
        
        int a = nums[j-1];
        int i = n-1;
        while(i > j && nums[i] <= a){
            i--;
        }
        swap(nums, i, j-1);
        reverse(nums, j, n-1);
    }
    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    private void reverse(int[] nums, int l, int r){
        while(l < r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}