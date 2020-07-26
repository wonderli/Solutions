import java.util.*;
public class Solution2{
    public int findKthLargest(int[] nums, int k) {
        sort(nums, 0, nums.length-1);
        return nums[nums.length - k];
    }
    public void sort(int[] nums, int start, int end){
        if(start >= end) return;
        int p = partition(nums, start, end);
        sort(nums, start, p-1);
        sort(nums, p+1, end);
    }
    public int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        int i = start - 1;
        for(int j = start; j < end; j++){
            if(nums[j] < pivot){
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, end);
        return i+1;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int[] nums = {3, 2, 1, 7, 5, 6, 4};
        System.out.println(sol.findKthLargest(nums, 2));
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
