import java.util.*;
public class Solution2{
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int i = 0;
        while(i < len){
            if(nums[i] < nums.length && nums[i] != nums[nums[i]]){
                swap(nums, i, nums[i]);
            }else{
                i++;
            }
        }
        for(int j = 0; j < len; j++){
            if(nums[j] != j){
                return j;
            }
        }
        return nums.length;
    }
    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int[] a = {3, 1, 0};
        System.out.println(sol.missingNumber(a));
    }
}
