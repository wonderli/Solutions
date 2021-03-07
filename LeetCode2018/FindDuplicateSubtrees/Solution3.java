import java.util.*;
class Solution{
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int a = nums[i] - 1;
            if(nums[a] != i + 1){
                swap(nums, i, a);
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return 0;
    }
    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
