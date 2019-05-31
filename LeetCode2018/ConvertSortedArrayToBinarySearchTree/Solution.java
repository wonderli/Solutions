import java.util.*;
public class Solution{
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length-1 );
    }
    private TreeNode sortedArrayToBST(int[] nums, int left, int right){
        if(right < left) return null;
        int mid = left + (right - left) /2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = sortedArrayToBST(nums, left, mid - 1);
        n.right = sortedArrayToBST(nums, mid + 1, right);
        return n;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] nums = {-10,-3,0,5,9};
        sol.sortedArrayToBST(nums);
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
