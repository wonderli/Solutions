import java.util.*;
public class Solution2{
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int len = nums.length;
        return sortedArrayToBST(nums, 0, len-1);
    }
    public TreeNode sortedArrayToBST(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, right);
        return root;
    }
    
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
