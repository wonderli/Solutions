import java.util.*;
public class Solution{
    Integer res = null;
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        search(nums, target, 0, nums.length - 1);
        return res == null ? -1 : res;
    }
    public void search(int[] nums, int target, int start, int end){
        if(start > end) return;
        if(res != null) return;
        int mid = start + (end - start)/2;
        if(nums[mid] == target){
            res = mid;
            return;
        }else {
            search(nums, target, start, mid - 1);
            search(nums, target, mid + 1, end);
        }
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
