import java.util.*;
public class Solution{
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        int left = helper(nums, target, true);
        if(left == nums.length || nums[left] != target){
            return ret;
        }
        ret[0] = left;
        ret[1] = helper(nums, target, false) - 1;
        return ret;
    }
    public int helper(int[] nums, int target, boolean left){
        int l = 0;
        int r = nums.length;
        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] > target || (left && target == nums[mid])){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
