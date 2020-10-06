import java.util.*;
public class Solution2{
    public void sortColors(int[] nums){
        int low = 0;
        int high = nums.length - 1;
        int i = 0;
        while(i <= high){
            if(nums[i]==0){
                swap(nums, i, low);
                low++;
                i++;
            }else if(nums[i] == 1){
                i++;
            }else if(nums[i] == 2){
                swap(nums, i, high);
                high--;
            }
        }
    }
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] =tmp;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
