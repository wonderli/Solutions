import java.util.*;
public class Solution{
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    public void quickSort(int[] nums, int l, int r){
        if(l > r) return;
        int p = partition(nums, l, r);
        quickSort(nums, l, p -1);
        quickSort(nums, p+1, r);
    }
    public int partition(int[] nums, int l, int r){
        int pivot = nums[r];
        int i = l - 1;
        for(int j = l; j < r; j++){
            if(nums[j] < pivot){
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, r);
        return i+1;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] a = {5, 4, 2,1 };
        System.out.println(Arrays.toString(sol.sortArray(a)));
        int[] b = {5,1,1,2,0,0};
        System.out.println(Arrays.toString(sol.sortArray(b)));
    }
}
