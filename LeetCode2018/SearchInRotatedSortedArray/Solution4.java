import java.util.*;
public class Solution4{
    public int search(int[] nums, int target){
        if(nums == null || nums.length == 0) return -1;
        return helper(nums, 0, nums.length - 1, target);
    }
    public int helper(int[] nums, int start, int end, int target){
        if(start > end) return -1;
        int mid = start + (end - start)/2;
        if(nums[mid] == target) return mid;
        if(nums[start] <= nums[mid]){
            if(nums[start] <= target && target < nums[mid]){
                return helper(nums, start, mid - 1, target);
            }else {
                return helper(nums, mid + 1, end, target);
            }
        }else {
            if(nums[mid] < target && target <= nums[end]){
                return helper(nums, mid + 1, end, target);
            }else {
                return helper(nums, start, mid - 1, target);
            }
        }
    }
    public static void main(String args[]){
        Solution4 sol = new Solution4();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
