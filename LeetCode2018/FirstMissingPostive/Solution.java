import java.util.*;
public class Solution{
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0){
            return 1;
        }
        int i = 0;
        int len = nums.length;
        while(i < len){
            int curr  = nums[i] - 1;
            if(curr >= 0 && curr < len && nums[i] != nums[curr]){
                swap(nums, i, curr);
            }else{
                i++;
            }
        }
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j+1){
                return j+1;
            }
        }
        return len + 1;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] =tmp;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] a = {1, 2, 0};
        System.out.println(sol.firstMissingPositive(a));
    }
}
