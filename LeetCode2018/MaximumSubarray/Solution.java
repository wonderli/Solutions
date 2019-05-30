import java.util.*;
public class Solution{
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		int max = nums[0];
		int maxCurrent = nums[0];
		for(int i = 1; i < nums.length; i++){
			maxCurrent = Math.max(maxCurrent + nums[i], nums[i]);
			max = Math.max(max, maxCurrent);
		}
		return max;
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
