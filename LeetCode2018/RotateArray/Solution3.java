import java.util.*;
public class Solution3{
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        swap(nums, 0, n - 1 - k);
        swap(nums, n - k, n-1);
        swap(nums, 0, n -1);
    }
    public void swap(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
