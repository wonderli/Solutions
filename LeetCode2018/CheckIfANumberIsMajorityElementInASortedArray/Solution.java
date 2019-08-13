import java.util.*;
public class Solution{
    public boolean isMajorityElement(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int curr = -1;
        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] >= target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l + n/2 < n && nums[l + n/2] == target;
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
