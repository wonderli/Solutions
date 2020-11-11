import java.util.*;
public class Solution{
    public void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int n = nums.length;
        int left = (n + 1)/2 -1;
        int right = n-1;
        for(int i = 0; i < nums.length; i++){
            if(i %2== 1){
                nums[i] = copy[right];
                right--;
            }else{
                nums[i] = copy[left];
                left--;
            }
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
