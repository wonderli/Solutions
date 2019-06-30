import java.util.*;
public class Solution{
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int len = nums.length;
        if(len == 1) return;
        while(i < len && j < len){
            while(j < len && nums[j] == 0){
                j++;
            }
            if(j == len) break;
            swap(nums, i, j);
            i++;
            j++;
        }
    }
    public void swap(int[] nums, int i, int j){
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //int[] nums = {0,1, 0, 3, 12};
        int[] nums = {0, 1};
        //int[] nums = {1, 0};
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
