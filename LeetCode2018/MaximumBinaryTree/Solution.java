import java.util.*;
public class Solution{
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end){
        if(start > end) return null;
        int max = findMax(nums, start, end);
        TreeNode maxNode = new TreeNode(nums[max]);
        maxNode.left = constructMaximumBinaryTree(nums, start, max - 1);
        maxNode.right = constructMaximumBinaryTree(nums, max + 1, end);
        return maxNode;
    }
    public int findMax(int[] nums, int start, int end){
        int max = Integer.MIN_VALUE;
        int maxIndex = start;
        for(int i = start; i <= end; i++){
            if(nums[i] > max){
                maxIndex = i;
                max = nums[i];
            }
        }
        return maxIndex;
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
