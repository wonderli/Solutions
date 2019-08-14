import java.util.*;
public class Solution{
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int r = nums.length - 1;
        int l = 0;
        while(l  <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid+1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
