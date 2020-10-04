import java.util.*;
public class Solution2{
    public int findPairs(int[] nums, int k) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int i = 0;
        int j = i + 1;
        int count = 0;
        while(i < nums.length  && j < nums.length){
            if(i == j || nums[j] - nums[i] < k){
                j++;
            }else if(nums[j] - nums[i] > k){
                i++;
            }else{
                i++;
                count++;
                while(i < nums.length  && nums[i] ==nums[i-1]){
                    i++;
                }
            }
        }
        return count;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        //int[] a = {1, 2, 3, 4, 5};
        //int[] a = {1, 3, 1, 5, 4};
        int[] a= {1,2,4,4,3,3,0,9,2,3};
        System.out.println(sol.findPairs(a, 3));
    }
}
