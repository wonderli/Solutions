import java.util.*;
public class Solution2{
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        int left = helper(nums, target, true);
        if(left == nums.length || nums[left] != target){
            return ret;
        }
        ret[0] = left;
        int m = helper(nums, target, false);
        ret[1] = m;
        return ret;
    }
    public int helper(int[] nums, int target, boolean left){
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else {
                if(left){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }
        return left ? l : r;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
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
